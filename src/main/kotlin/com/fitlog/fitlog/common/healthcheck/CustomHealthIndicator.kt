package com.fitlog.fitlog.common.healthcheck

import com.fitlog.fitlog.common.healthcheck.warmer.DataSourceWarmer
import com.fitlog.fitlog.common.healthcheck.warmer.DataSourceWarmerException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.boot.actuate.health.AbstractHealthIndicator
import org.springframework.boot.actuate.health.Health
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger { }

@Component
class CustomHealthIndicator(
    private val dataSourceWarmer: DataSourceWarmer
) : AbstractHealthIndicator() {
    override fun doHealthCheck(builder: Health.Builder?) {
        try {
            dataSourceWarmer.doRun()
        } catch (e: DataSourceWarmerException) {
            logger.error { "CustomHealthIndicator | warm up error $e" }
            builder!!.outOfService()
        }
        builder!!.build()
    }
}
