package me.luvram.trycleanarchitecture.common

import org.springframework.stereotype.Component
import kotlin.annotation.AnnotationTarget.CLASS

@Target(CLASS)
@Retention
@MustBeDocumented
@Component
annotation class UseCase(
    val value: String = ""
)
