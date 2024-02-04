package com.sample.sample.user.application.service

import com.sample.sample.user.application.exception.UserNotFoundException
import com.sample.sample.user.application.port.`in`.GetUserLocationQuery
import com.sample.sample.user.application.port.`in`.GetUserLocationUseCase
import com.sample.sample.user.application.port.out.GetUserPersistencePort
import com.sample.sample.user.domain.model.UserWithLocation
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GetUserLocationService(
    private val getUserPersistencePort: GetUserPersistencePort,
) : GetUserLocationUseCase {
    override fun execute(query: GetUserLocationQuery): UserWithLocation {
        val user = getUserPersistencePort.findById(id = query.userId) ?: throw UserNotFoundException()
        return user.let {
            UserWithLocation(
                userId = it.id,
                nickname = it.nickname,
                location = it.location,
                stayedAt = it.stayedAt,
            )
        }
    }
}
