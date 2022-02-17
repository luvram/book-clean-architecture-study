package me.luvram.trycleanarchitecture.account.application.service

import me.luvram.trycleanarchitecture.account.domain.Money

class ThresholdExceededException(
    threshold: Money,
    actual: Money
    ): RuntimeException("Maximum threshold for transferring money exceeded: tried to transfer $actual but threshold is $threshold") {
}
