package com.sample.sample.user.application.port.`in`

import com.sample.sample.user.domain.model.UserWithLocation

data class GetFriendLocationsQuery(val userId: Long)

interface GetFriendLocationsUseCase {
    fun execute(query: GetFriendLocationsQuery): List<UserWithLocation>
}
