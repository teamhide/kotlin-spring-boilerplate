package com.sample.sample.location.application.port.out

import com.sample.sample.location.domain.model.UpdateUserLocation

interface MessagingPort {
    fun sendLocationUpdated(message: UpdateUserLocation)
}
