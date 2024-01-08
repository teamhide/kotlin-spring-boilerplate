package com.sample.sample.user.application.port.`in`

data class AddFriendCommand(val userId: Long, val friendUserId: Long)

interface AddFriendUseCase {
    fun execute(command: AddFriendCommand)
}
