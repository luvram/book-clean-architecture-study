package me.luvram.trycleanarchitecture.account.domain

import java.math.BigInteger

class Money(
    private val amount: BigInteger
) {

    companion object {
        val ZERO = Money.of(0)

        fun of(value: Long): Money {
            return Money(BigInteger.valueOf(value))
        }

        fun add(a: Money, b: Money): Money {
            return Money(a.amount.add(b.amount))
        }

        fun subtract(a: Money, b: Money): Money {
            return Money(a.amount.subtract(b.amount))
        }
    }



    fun isPositiveOrZero(): Boolean {
        return this.amount >= BigInteger.ZERO
    }

    fun isNegative(): Boolean {
        return this.amount.compareTo(BigInteger.ZERO) < 0
    }

    fun isGreaterThanOrEqualTo(money: Money): Boolean {
        return this.amount.compareTo(money.amount) >= 1
    }

    fun isGreaterThan(money: Money): Boolean {
        return this.amount.compareTo(money.amount) >= 1
    }

    fun minus(money: Money): Money {
        return Money(this.amount.subtract(money.amount))
    }

    fun plus(money: Money): Money {
        return Money(this.amount.add(money.amount))
    }

    fun negate(): Money {
        return Money(this.amount.negate())
    }




}
