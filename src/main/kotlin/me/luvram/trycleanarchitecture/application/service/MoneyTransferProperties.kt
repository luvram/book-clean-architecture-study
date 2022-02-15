package me.luvram.trycleanarchitecture.application.service

import me.luvram.trycleanarchitecture.domain.Money

class MoneyTransferProperties(
    val maximumTransferThreshold: Money = Money.of(1_000_000L)
) {

}
