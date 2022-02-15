package me.luvram.trycleanarchitecture.application.port.out

import me.luvram.trycleanarchitecture.domain.Account

interface UpdateAccountStatePort {
    fun updateActivities(account: Account)
}
