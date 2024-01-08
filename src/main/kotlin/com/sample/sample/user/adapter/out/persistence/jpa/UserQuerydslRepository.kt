package com.sample.sample.user.adapter.out.persistence.jpa

import com.sample.sample.user.domain.vo.UserStatus

interface UserQuerydslRepository {
    fun updateLocationById(userId: Long, lat: Double, lng: Double): Long

    fun updateStatusById(userId: Long, status: UserStatus): Long
}
