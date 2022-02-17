package me.luvram.trycleanarchitecture.account.domain

import java.time.LocalDateTime

class Activity(
    val ownerAccountId: Account.AccountId,
    val sourceAccountId: Account.AccountId,
    val targetAccountId: Account.AccountId,
    val timestamp: LocalDateTime,
    val money: Money
) {
    val id: ActivityId? = null

    class ActivityId {
        private val value: Long? = null
    }
}
