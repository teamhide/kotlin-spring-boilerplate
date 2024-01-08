package com.sample.sample.user.application.service

import com.sample.sample.user.application.exception.UserNotFoundException
import com.sample.sample.user.application.port.`in`.GetUserQuery
import com.sample.sample.user.application.port.`in`.GetUserUseCase
import com.sample.sample.user.application.port.out.GetUserPersistencePort
import com.sample.sample.user.domain.model.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GetUserService(
    private val getUserPersistencePort: GetUserPersistencePort,
) : GetUserUseCase {
    override fun execute(query: GetUserQuery): User {
        return getUserPersistencePort.findById(id = query.userId) ?: run {
            throw UserNotFoundException()
        }
    }
}
