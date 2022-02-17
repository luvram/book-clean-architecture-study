package me.luvram.trycleanarchitecture.account.application.service

import me.luvram.trycleanarchitecture.account.domain.Money

class MoneyTransferProperties(
    val maximumTransferThreshold: Money = Money.of(1_000_000L)
) {

}
