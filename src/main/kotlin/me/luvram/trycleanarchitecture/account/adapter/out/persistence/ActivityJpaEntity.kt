package me.luvram.trycleanarchitecture.account.adapter.out.persistence

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "activity")
class ActivityJpaEntity(
    @Id
    @GeneratedValue
    val id: Long?,
    @Column
    val timestamp: LocalDateTime,
    @Column
    val ownerAccountId: Long,
    @Column
    val sourceAccountId: Long,
    @Column
    val targetAccountId: Long,
    @Column
    val amount: Long
)
