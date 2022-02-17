package me.luvram.trycleanarchitecture.account.adapter.out.persistence

import me.luvram.trycleanarchitecture.account.application.port.out.LoadAccountPort
import me.luvram.trycleanarchitecture.account.application.port.out.UpdateAccountStatePort
import me.luvram.trycleanarchitecture.account.domain.Account
import me.luvram.trycleanarchitecture.account.domain.Account.AccountId
import me.luvram.trycleanarchitecture.common.PersistenceAdapter
import java.time.LocalDateTime

@PersistenceAdapter
class AccountPersistenceAdapter(
    
): LoadAccountPort, UpdateAccountStatePort {
    override fun loadAccount(accountId: AccountId, baselineDate: LocalDateTime): Account {
        TODO("Not yet implemented")
    }

    override fun updateActivities(account: Account) {
        TODO("Not yet implemented")
    }
}
