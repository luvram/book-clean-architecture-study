package me.luvram.trycleanarchitecture.account.adapter.out.persistence

import me.luvram.trycleanarchitecture.account.application.port.out.LoadAccountPort
import me.luvram.trycleanarchitecture.account.application.port.out.UpdateAccountStatePort
import me.luvram.trycleanarchitecture.account.domain.Account
import me.luvram.trycleanarchitecture.account.domain.Account.AccountId
import me.luvram.trycleanarchitecture.common.PersistenceAdapter
import java.time.LocalDateTime
import javax.persistence.EntityNotFoundException

@PersistenceAdapter
class AccountPersistenceAdapter(
    private val accountRepository: SpringDataAccountRepository,
    private val activityRepository: ActivityRepository,
    private val accountMapper: AccountMapper
): LoadAccountPort, UpdateAccountStatePort {
    override fun loadAccount(accountId: AccountId, baselineDate: LocalDateTime): Account {

        val account = accountRepository.findById(accountId.value).orElseThrow { EntityNotFoundException() }
        val activities = activityRepository.findByOwnerSince(accountId.value, baselineDate)

        val withdrawalBalance = activityRepository.getWithdrawalBalanceUntil(accountId.value, baselineDate)
        val depositBalance = activityRepository.getDepositBalanceUntil(accountId.value, baselineDate)

        return accountMapper.mapToDomainEntity(
            account,
            activities,
            withdrawalBalance,
            depositBalance
        )
    }

    private fun orZero(value: Long?): Long {
        return value ?: 0L
    }

    override fun updateActivities(account: Account) {
        for (activity in account.activityWindow.activities) {
            if (activity.id == null) {
                activityRepository.save(accountMapper.mapToJpaEntity(activity))
            }

        }
    }
}
