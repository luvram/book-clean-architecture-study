package me.luvram.trycleanarchitecture.application.port.out

import me.luvram.trycleanarchitecture.domain.Account
import me.luvram.trycleanarchitecture.domain.Account.AccountId

interface AccountLock {
    fun lockAccount(accountId: Account.AccountId)

    fun releaseAccount(accountId: AccountId)
}
