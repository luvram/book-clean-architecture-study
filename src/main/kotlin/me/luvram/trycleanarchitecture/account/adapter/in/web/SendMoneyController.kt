package me.luvram.trycleanarchitecture.account.adapter.`in`.web

import me.luvram.trycleanarchitecture.account.application.port.`in`.SendMoneyCommand
import me.luvram.trycleanarchitecture.account.application.port.`in`.SendMoneyUseCase
import me.luvram.trycleanarchitecture.account.domain.Account.AccountId
import me.luvram.trycleanarchitecture.account.domain.Money
import me.luvram.trycleanarchitecture.account.domain.Money.Companion
import me.luvram.trycleanarchitecture.common.WebAdapter
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@RestController
class SendMoneyController(
    private val sendMoneyUseCase: SendMoneyUseCase
) {

    @PostMapping("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    fun sendMoney(
        @PathVariable("sourceAccountId") sourceAccountId: Long,
        @PathVariable("targetAccountId") targetAccountId: Long,
        @PathVariable("amount") amount: Long
    ) {
        val command = SendMoneyCommand(
            AccountId(sourceAccountId),
            AccountId(targetAccountId),
            Money.of(amount)
        )

        sendMoneyUseCase.sendMoney(command)
    }
}
