package com.sample.sample.user.adapter.out.persistence.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long>, UserQuerydslRepository {
    fun findByEmailOrNickname(email: String, nickname: String): UserEntity?

    fun findAllByIdIn(ids: List<Long>): List<UserEntity>
}
