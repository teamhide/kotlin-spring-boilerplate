package com.locly.locly.user.application.port.out

import com.locly.locly.user.domain.vo.Location
import com.locly.locly.user.domain.vo.UserStatus

interface UpdateUserPersistencePort {
    fun updateLocationById(userId: Long, location: Location): Long

    fun updateStatusById(userId: Long, status: UserStatus): Long
}
