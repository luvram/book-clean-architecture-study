package me.luvram.trycleanarchitecture.domain

import org.springframework.beans.factory.annotation.Value

class Account(
    val id: AccountId,
    val baselineBalance: Money,
    val activityWindow: ActivityWindow

) {


    class AccountId {
        private val value: Long? = null
    }
}
