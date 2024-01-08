package com.sample.sample.user.application.port.`in`

import com.sample.sample.user.domain.model.User

data class RegisterUserCommand(
    val password: String,
    val email: String,
    val nickname: String,
    val lat: Double,
    val lng: Double,
)
interface RegisterUserUseCase {
    fun execute(command: RegisterUserCommand): User
}
