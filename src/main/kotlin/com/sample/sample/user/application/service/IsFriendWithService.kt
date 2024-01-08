package com.sample.sample.user.application.service

import com.sample.sample.user.application.port.`in`.IsFriendWithQuery
import com.sample.sample.user.application.port.`in`.IsFriendWithUseCase
import com.sample.sample.user.application.port.out.GetUserFriendPersistencePort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class IsFriendWithService(
    private val getUserFriendPersistencePort: GetUserFriendPersistencePort,
) : IsFriendWithUseCase {
    override fun execute(query: IsFriendWithQuery): Boolean {
        return getUserFriendPersistencePort.isFriendWith(userId = query.userId, friendUserId = query.friendUserId)
    }
}
