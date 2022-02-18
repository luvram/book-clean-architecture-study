package me.luvram.trycleanarchitecture

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "buckpal")
class BuckPalConfigurationProperties(
    var transferThreshold:Long = Long.MAX_VALUE
)
