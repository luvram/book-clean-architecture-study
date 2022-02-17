package me.luvram.trycleanarchitecture.account.application.service

import me.luvram.trycleanarchitecture.account.application.port.out.AccountLock
import me.luvram.trycleanarchitecture.account.domain.Account.AccountId
import org.springframework.stereotype.Component

@Component
class NoOpAccountLock: AccountLock {
    override fun lockAccount(accountId: AccountId) {
        // do nothing
    }

    override fun releaseAccount(accountId: AccountId) {
        // do nothing
    }
}
