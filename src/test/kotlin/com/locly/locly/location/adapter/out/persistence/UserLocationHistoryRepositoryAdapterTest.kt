package com.locly.locly.location.adapter.out.persistence

import com.locly.locly.location.adapter.out.persistence.mongo.UserLocationHistoryRepository
import com.locly.locly.location.makeUserLocationHistory
import com.locly.locly.location.makeUserLocationHistoryEntity
import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class UserLocationHistoryRepositoryAdapterTest : StringSpec({
    val userLocationHistoryRepository = mockk<UserLocationHistoryRepository>()
    val repositoryAdapter = UserLocationHistoryRepositoryAdapter(
        userLocationHistoryRepository = userLocationHistoryRepository,
    )

    "유저 위치 내역을 저장한다" {
        // Given
        val history = makeUserLocationHistory()
        val historyEntity = makeUserLocationHistoryEntity()
        every { userLocationHistoryRepository.save(any()) } returns historyEntity

        // When
        repositoryAdapter.save(history = history)

        // Then
        verify(exactly = 1) { userLocationHistoryRepository.save(any()) }
    }
})