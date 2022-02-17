package me.luvram.trycleanarchitecture.account.application.port.`in`

import me.luvram.trycleanarchitecture.account.domain.Account.AccountId
import me.luvram.trycleanarchitecture.account.domain.Money

class SendMoneyCommand(
    val sourceAccountId: AccountId,
    val targetAccountId: AccountId,
    val money: Money
) {
  // todo SelfValidating 을 생략하였다.
}
