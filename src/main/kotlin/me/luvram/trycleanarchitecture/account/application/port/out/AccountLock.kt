package me.luvram.trycleanarchitecture.account.application.port.out

import me.luvram.trycleanarchitecture.account.domain.Account
import me.luvram.trycleanarchitecture.account.domain.Account.AccountId

interface AccountLock {
    fun lockAccount(accountId: Account.AccountId)

    fun releaseAccount(accountId: AccountId)
}
