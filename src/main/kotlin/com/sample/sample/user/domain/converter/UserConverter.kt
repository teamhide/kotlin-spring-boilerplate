package com.sample.sample.user.domain.converter

import com.sample.sample.common.geospatial.PointConverter
import com.sample.sample.user.adapter.out.persistence.jpa.UserEntity
import com.sample.sample.user.domain.model.User
import com.sample.sample.user.domain.vo.Location

class UserConverter private constructor() {
    companion object {
        fun from(user: UserEntity): User {
            with(user) {
                return User(
                    id = id,
                    password = password,
                    email = email,
                    nickname = nickname,
                    status = status,
                    location = Location(lat = location.x, lng = location.y),
                    stayedAt = stayedAt,
                )
            }
        }

        fun to(user: User): UserEntity {
            with(user) {
                return UserEntity(
                    id = id,
                    password = password,
                    email = email,
                    nickname = nickname,
                    status = status,
                    location = PointConverter.from(lat = location.lat, lng = location.lng),
                    stayedAt = stayedAt,
                )
            }
        }
    }
}
