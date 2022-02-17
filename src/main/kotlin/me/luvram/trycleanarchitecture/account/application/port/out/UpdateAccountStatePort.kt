package me.luvram.trycleanarchitecture.account.application.port.out

import me.luvram.trycleanarchitecture.account.domain.Account

interface UpdateAccountStatePort {
    fun updateActivities(account: Account)
}
