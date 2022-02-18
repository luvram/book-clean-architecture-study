package me.luvram.trycleanarchitecture.account.adapter.out.persistence

import me.luvram.trycleanarchitecture.account.domain.Account
import me.luvram.trycleanarchitecture.account.domain.Account.AccountId
import me.luvram.trycleanarchitecture.account.domain.Activity
import me.luvram.trycleanarchitecture.account.domain.Activity.ActivityId
import me.luvram.trycleanarchitecture.account.domain.ActivityWindow
import me.luvram.trycleanarchitecture.account.domain.Money
import me.luvram.trycleanarchitecture.account.domain.Money.Companion
import org.springframework.stereotype.Component

@Component
class AccountMapper {

    fun mapToDomainEntity(
        account: AccountJpaEntity,
        activities: List<ActivityJpaEntity>,
        withdrawalBalance: Long,
        depositBalance: Long
    ): Account {
        val baselineBalance = Money.subtract(
            Money.of(depositBalance),
            Money.of(withdrawalBalance)
        )

        return Account.withId(
            AccountId(account.id),
            baselineBalance,
            mapToActivityWindow(activities)
        )
    }

    fun mapToActivityWindow(activities: List<ActivityJpaEntity>): ActivityWindow {
        val mappedActivities: MutableList<Activity> = mutableListOf()

        for (activity in activities) {
            mappedActivities.add(
                Activity(
                    ActivityId(activity.id),
                    AccountId(activity.ownerAccountId),
                    AccountId(activity.sourceAccountId),
                    AccountId(activity.targetAccountId),
                    activity.timestamp,
                    Money.of(activity.amount)
                )
            )
        }

        return ActivityWindow(mappedActivities)
    }

    fun mapToJpaEntity(activity: Activity): ActivityJpaEntity {
        return ActivityJpaEntity(
            activity.id?.value,
            activity.timestamp,
            activity.ownerAccountId.value,
            activity.sourceAccountId.value,
            activity.targetAccountId.value,
            activity.money.amount.longValueExact()
        )
    }
}
