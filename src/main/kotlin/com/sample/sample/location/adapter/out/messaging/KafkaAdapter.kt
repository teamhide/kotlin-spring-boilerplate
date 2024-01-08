package com.sample.sample.location.adapter.out.messaging

import com.sample.sample.location.application.port.out.MessagingPort
import com.sample.sample.location.domain.model.UpdateUserLocation
import org.springframework.stereotype.Component

@Component
class KafkaAdapter(
    private val updateLocationProducer: UpdateLocationProducer,
) : MessagingPort {
    override fun sendLocationUpdated(message: UpdateUserLocation) {
        updateLocationProducer.send(key = message.userId.toString(), message = message)
    }
}
