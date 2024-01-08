package com.sample.sample.location.application.port.`in`

import com.sample.sample.user.domain.model.UserWithLocation

data class GetLocationsQuery(val userId: Long)
interface GetLocationsUseCase {
    fun execute(query: GetLocationsQuery): List<UserWithLocation>
}
