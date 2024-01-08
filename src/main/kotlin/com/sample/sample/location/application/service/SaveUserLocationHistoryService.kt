package com.sample.sample.location.application.service

import com.sample.sample.location.application.port.`in`.SaveUserLocationHistoryCommand
import com.sample.sample.location.application.port.`in`.SaveUserLocationHistoryUseCase
import com.sample.sample.location.application.port.out.SaveLocationHistoryPersistencePort
import com.sample.sample.location.domain.model.UserLocationHistory
import org.springframework.stereotype.Service

@Service
class SaveUserLocationHistoryService(
    private val persistencePort: SaveLocationHistoryPersistencePort,
) : SaveUserLocationHistoryUseCase {
    override fun execute(command: SaveUserLocationHistoryCommand) {
        val history = command.let {
            UserLocationHistory(
                userId = it.userId,
                location = it.location,
            )
        }
        persistencePort.save(history = history)
    }
}
