package com.locly.locly.user.application.port.`in`

import com.locly.locly.user.domain.vo.UserStatus

data class UpdateStatusCommand(val userId: Long, val status: UserStatus)

interface UpdateStatusUseCase {
    fun execute(command: UpdateStatusCommand)
}
