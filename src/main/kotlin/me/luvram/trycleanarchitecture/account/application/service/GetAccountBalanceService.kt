package me.luvram.trycleanarchitecture.account.application.service

import me.luvram.trycleanarchitecture.account.application.port.`in`.GetAccountBalanceQuery
import me.luvram.trycleanarchitecture.account.application.port.out.LoadAccountPort
import me.luvram.trycleanarchitecture.account.domain.Account.AccountId
import me.luvram.trycleanarchitecture.account.domain.Money
import java.time.LocalDateTime

class GetAccountBalanceService(
    private val loadAccountPort: LoadAccountPort
): GetAccountBalanceQuery {
    override fun getAccountBalance(accountId: AccountId): Money {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now()).calculateBalance()
    }
}
