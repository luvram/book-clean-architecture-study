package me.luvram.trycleanarchitecture.account.application.service

import me.luvram.trycleanarchitecture.account.application.port.`in`.SendMoneyCommand
import me.luvram.trycleanarchitecture.account.application.port.`in`.SendMoneyUseCase
import me.luvram.trycleanarchitecture.account.application.port.out.AccountLock
import me.luvram.trycleanarchitecture.account.application.port.out.LoadAccountPort
import me.luvram.trycleanarchitecture.account.application.port.out.UpdateAccountStatePort
import me.luvram.trycleanarchitecture.common.UseCase
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@UseCase
@Transactional
class SendMoneyService(
    private val loadAccountPort: LoadAccountPort,
    private val accountLock: AccountLock,
    private val updateAccountStatePort: UpdateAccountStatePort,
    private val moneyTransferProperties: MoneyTransferProperties
): SendMoneyUseCase {
    override fun sendMoney(command: SendMoneyCommand): Boolean {
        checkThreshold(command)

        val baselineDate = LocalDateTime.now().minusDays(10)

        val sourceAccount = loadAccountPort.loadAccount(command.sourceAccountId, baselineDate)
        val targetAccount = loadAccountPort.loadAccount(command.targetAccountId, baselineDate)

        val sourceAccountId = sourceAccount.id ?: throw IllegalStateException("expected source account ID not to be empty")
        val targetAccountId = targetAccount.id ?: throw IllegalStateException("expected target account ID not to be empty")

        accountLock.lockAccount(sourceAccountId)
        if (!sourceAccount.withdraw(command.money, targetAccountId)) {
            accountLock.releaseAccount(sourceAccountId)
            return false
        }

        accountLock.lockAccount(targetAccountId)
        if (!targetAccount.deposit(command.money, sourceAccountId)) {
            accountLock.releaseAccount(sourceAccountId)
            accountLock.releaseAccount(targetAccountId)
        }

        updateAccountStatePort.updateActivities(sourceAccount)
        updateAccountStatePort.updateActivities(targetAccount)

        accountLock.releaseAccount(sourceAccountId)
        accountLock.releaseAccount(targetAccountId)

        return true
    }

    private fun checkThreshold(command: SendMoneyCommand) {
        if (command.money.isGreaterThan(moneyTransferProperties.maximumTransferThreshold)) {
            throw ThresholdExceededException(moneyTransferProperties.maximumTransferThreshold, command.money)
        }
    }
}
