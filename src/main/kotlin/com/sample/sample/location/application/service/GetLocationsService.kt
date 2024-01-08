package com.sample.sample.location.application.service

import com.sample.sample.location.application.port.`in`.GetLocationsQuery
import com.sample.sample.location.application.port.`in`.GetLocationsUseCase
import com.sample.sample.location.application.port.out.UserExternalPort
import com.sample.sample.user.domain.model.UserWithLocation
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GetLocationsService(
    private val userExternalPort: UserExternalPort,
) : GetLocationsUseCase {
    override fun execute(query: GetLocationsQuery): List<UserWithLocation> {
        return userExternalPort.getFriendLocations(userId = query.userId)
    }
}
