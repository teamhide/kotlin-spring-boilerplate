package com.sample.sample.user.application.port.`in`

import com.sample.sample.user.domain.vo.UserStatus

data class UpdateStatusCommand(val userId: Long, val status: UserStatus)

interface UpdateStatusUseCase {
    fun execute(command: UpdateStatusCommand)
}
