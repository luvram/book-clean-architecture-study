package me.luvram.trycleanarchitecture

import me.luvram.trycleanarchitecture.account.application.service.MoneyTransferProperties
import me.luvram.trycleanarchitecture.account.domain.Money
import me.luvram.trycleanarchitecture.account.domain.Money.Companion
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(BuckPalConfigurationProperties::class)
class BuckPalConfigurationConfiguration {
    @Bean
    fun moneyTransferProperties(buckPalConfigurationProperties: BuckPalConfigurationProperties): MoneyTransferProperties {
        return MoneyTransferProperties(Money.of(buckPalConfigurationProperties.transferThreshold))
    }
}
