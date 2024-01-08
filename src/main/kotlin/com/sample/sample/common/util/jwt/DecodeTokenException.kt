package com.sample.sample.common.util.jwt

import com.sample.sample.common.exception.CustomException
import org.springframework.http.HttpStatus

class DecodeTokenException : CustomException(
    statusCode = HttpStatus.UNAUTHORIZED,
    errorCode = "AUTH__INVALID_TOKEN",
    message = ""
)
