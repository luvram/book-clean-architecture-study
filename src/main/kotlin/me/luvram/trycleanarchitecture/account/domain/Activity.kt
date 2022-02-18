package me.luvram.trycleanarchitecture.account.domain

import java.time.LocalDateTime

class Activity(
    val id: ActivityId? = null,
    val ownerAccountId: Account.AccountId,
    val sourceAccountId: Account.AccountId,
    val targetAccountId: Account.AccountId,
    val timestamp: LocalDateTime,
    val money: Money
) {

    constructor(
        ownerAccountId: Account.AccountId,
        sourceAccountId: Account.AccountId,
        targetAccountId: Account.AccountId,
        timestamp: LocalDateTime,
        money: Money
    ): this(null, ownerAccountId, sourceAccountId, targetAccountId, timestamp, money)

    class ActivityId(
        val value: Long?
    )
}
