package me.luvram.trycleanarchitecture.application.port.out

import me.luvram.trycleanarchitecture.domain.Account
import me.luvram.trycleanarchitecture.domain.Account.AccountId
import java.time.LocalDateTime

interface LoadAccountPort {
    fun loadAccount(accountId: AccountId, baselineDate: LocalDateTime): Account
}
