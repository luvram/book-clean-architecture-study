package me.luvram.trycleanarchitecture.application.port.`in`

import me.luvram.trycleanarchitecture.domain.Account.AccountId
import me.luvram.trycleanarchitecture.domain.Money

interface GetAccountBalanceQuery {
    fun getAccountBalance(accountId: AccountId): Money
}
