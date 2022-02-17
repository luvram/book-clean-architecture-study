package me.luvram.trycleanarchitecture.account.application.port.out

import me.luvram.trycleanarchitecture.account.domain.Account
import me.luvram.trycleanarchitecture.account.domain.Account.AccountId
import java.time.LocalDateTime

interface LoadAccountPort {
    fun loadAccount(accountId: AccountId, baselineDate: LocalDateTime): Account
}
