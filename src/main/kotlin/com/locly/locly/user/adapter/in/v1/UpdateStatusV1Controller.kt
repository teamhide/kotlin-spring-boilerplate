package com.locly.locly.user.adapter.`in`.v1

import com.locly.locly.common.response.ApiResponse
import com.locly.locly.common.security.CurrentUser
import com.locly.locly.user.application.port.`in`.UpdateStatusCommand
import com.locly.locly.user.application.port.`in`.UpdateStatusUseCase
import com.locly.locly.user.domain.vo.UserStatus
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class UpdateStatusRequest(val status: UserStatus)

@RestController
@RequestMapping("/api/v1/user/status")
class UpdateStatusV1Controller(
    private val useCase: UpdateStatusUseCase
) {
    @PutMapping("")
    fun updateStatus(
        @AuthenticationPrincipal currentUser: CurrentUser,
        @RequestBody @Valid body: UpdateStatusRequest
    ): ApiResponse<Void> {
        val command = UpdateStatusCommand(userId = currentUser.id, status = body.status)
        useCase.execute(command = command)
        return ApiResponse.success(statusCode = HttpStatus.OK)
    }
}
