package com.sample.sample.user.application.service

import com.sample.sample.user.application.port.`in`.GetFriendLocationsQuery
import com.sample.sample.user.application.port.`in`.GetFriendLocationsUseCase
import com.sample.sample.user.application.port.out.GetUserFriendPersistencePort
import com.sample.sample.user.application.port.out.GetUserPersistencePort
import com.sample.sample.user.domain.model.UserWithLocation
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GetFriendLocationsService(
    private val getUserPersistencePort: GetUserPersistencePort,
    private val getUserFriendPersistencePort: GetUserFriendPersistencePort,
) : GetFriendLocationsUseCase {
    override fun execute(query: GetFriendLocationsQuery): List<UserWithLocation> {
        val friendIds = getUserFriendPersistencePort.findAllFriendUserIdsByUserId(userId = query.userId)
        return getUserPersistencePort.findAllByIdIn(userIds = friendIds).map {
            UserWithLocation(
                userId = it.id,
                nickname = it.nickname,
                location = it.location,
                stayedAt = it.stayedAt,
            )
        }
    }
}
