package com.sample.sample.user.application.port.out

import com.sample.sample.user.domain.model.User

interface SaveUserPersistencePort {
    fun save(user: User): User
}
