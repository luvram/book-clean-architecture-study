package me.luvram.trycleanarchitecture.common

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component
import java.lang.annotation.Documented
import java.lang.annotation.RetentionPolicy.RUNTIME
import kotlin.annotation.AnnotationTarget.ANNOTATION_CLASS
import kotlin.annotation.AnnotationTarget.CLASS

@Target(AnnotationTarget.TYPE, CLASS)
@Retention
@MustBeDocumented
@Component
annotation class WebAdapter(
    val value: String = ""
) {

}

