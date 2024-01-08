package com.sample.sample.user.application.port.`in`

import com.sample.sample.user.domain.model.UserWithLocation

data class GetUserLocationQuery(val userId: Long)

interface GetUserLocationUseCase {
    fun execute(query: GetUserLocationQuery): UserWithLocation
}
