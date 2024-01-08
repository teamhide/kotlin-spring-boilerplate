package com.sample.sample.location.adapter.out.external

import com.sample.sample.location.application.port.out.UserExternalPort
import com.sample.sample.location.domain.vo.UserLocation
import com.sample.sample.user.application.port.`in`.GetFriendLocationsQuery
import com.sample.sample.user.application.port.`in`.GetFriendLocationsUseCase
import com.sample.sample.user.application.port.`in`.GetUserLocationQuery
import com.sample.sample.user.application.port.`in`.GetUserLocationUseCase
import com.sample.sample.user.application.port.`in`.GetUserQuery
import com.sample.sample.user.application.port.`in`.GetUserUseCase
import com.sample.sample.user.application.port.`in`.IsFriendWithQuery
import com.sample.sample.user.application.port.`in`.IsFriendWithUseCase
import com.sample.sample.user.application.port.`in`.UpdateUserLocationCommand
import com.sample.sample.user.application.port.`in`.UpdateUserLocationUseCase
import com.sample.sample.user.domain.model.User
import com.sample.sample.user.domain.model.UserWithLocation
import org.springframework.stereotype.Component

@Component
class UserExternalAdapter(
    private val getFriendLocationsUseCase: GetFriendLocationsUseCase,
    private val updateUserLocationUseCase: UpdateUserLocationUseCase,
    private val getUserLocationUseCase: GetUserLocationUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val isFriendWithUseCase: IsFriendWithUseCase,
) : UserExternalPort {
    override fun getFriendLocations(userId: Long): List<UserWithLocation> {
        val query = GetFriendLocationsQuery(userId = userId)
        return getFriendLocationsUseCase.execute(query = query)
    }

    override fun updateUserLocation(userId: Long, location: UserLocation): Long {
        val command = UpdateUserLocationCommand(userId = userId, lat = location.lat, lng = location.lng)
        return updateUserLocationUseCase.execute(command = command)
    }

    override fun getUserLocation(userId: Long): UserWithLocation {
        val query = GetUserLocationQuery(userId = userId)
        return getUserLocationUseCase.execute(query = query)
    }

    override fun getUser(userId: Long): User {
        val query = GetUserQuery(userId = userId)
        return getUserUseCase.execute(query = query)
    }

    override fun isFriendWith(userId: Long, friendUserId: Long): Boolean {
        val query = IsFriendWithQuery(userId = userId, friendUserId = friendUserId)
        return isFriendWithUseCase.execute(query = query)
    }
}
