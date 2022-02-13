package me.luvram.trycleanarchitecture.domain

import java.time.LocalDateTime

class Activity(
    val id: ActivityId,
    val ownerAccountId: Account.AccountId,
    val sourceAccountId: Account.AccountId,
    val targetAccountId: Account.AccountId,
    val timestamp: LocalDateTime,
    val money: Money
) {

    class ActivityId {
        private val value: Long? = null
    }
}
