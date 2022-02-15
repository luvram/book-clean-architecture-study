package me.luvram.trycleanarchitecture.application.service

import me.luvram.trycleanarchitecture.application.port.out.AccountLock
import me.luvram.trycleanarchitecture.domain.Account.AccountId
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
