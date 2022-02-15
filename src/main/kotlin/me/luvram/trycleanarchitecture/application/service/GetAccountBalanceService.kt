package me.luvram.trycleanarchitecture.application.service

import me.luvram.trycleanarchitecture.application.port.`in`.GetAccountBalanceQuery
import me.luvram.trycleanarchitecture.domain.Account.AccountId
import me.luvram.trycleanarchitecture.domain.Money

class GetAccountBalanceService: GetAccountBalanceQuery {
    override fun getAccountBalance(accountId: AccountId): Money {
        TODO("Not yet implemented")
    }
}
