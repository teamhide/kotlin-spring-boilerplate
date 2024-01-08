package com.sample.sample.user.application.port.`in`

import com.sample.sample.user.domain.model.User

data class GetUserQuery(val userId: Long)

interface GetUserUseCase {
    fun execute(query: GetUserQuery): User
}
