package com.sample.sample.location.application.port.out

import com.sample.sample.location.domain.model.UserLocationHistory

interface SaveLocationHistoryPersistencePort {
    fun save(history: UserLocationHistory)
}
