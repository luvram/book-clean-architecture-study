package me.luvram.trycleanarchitecture.account.application.port.`in`

import me.luvram.trycleanarchitecture.account.domain.Account.AccountId
import me.luvram.trycleanarchitecture.account.domain.Money

interface GetAccountBalanceQuery {
    fun getAccountBalance(accountId: AccountId): Money
}
