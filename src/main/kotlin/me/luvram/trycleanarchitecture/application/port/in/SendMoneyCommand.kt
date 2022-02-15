package me.luvram.trycleanarchitecture.application.port.`in`

import me.luvram.trycleanarchitecture.domain.Account.AccountId
import me.luvram.trycleanarchitecture.domain.Money

class SendMoneyCommand(
    val sourceAccountId: AccountId,
    val targetAccountId: AccountId,
    val money: Money
) {
  // todo SelfValidating 을 생략하였다.
}
