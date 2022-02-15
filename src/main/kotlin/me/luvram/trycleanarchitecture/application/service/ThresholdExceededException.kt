package me.luvram.trycleanarchitecture.application.service

import me.luvram.trycleanarchitecture.domain.Money

class ThresholdExceededException(
    threshold: Money,
    actual: Money
    ): RuntimeException("Maximum threshold for transferring money exceeded: tried to transfer $actual but threshold is $threshold") {
}
