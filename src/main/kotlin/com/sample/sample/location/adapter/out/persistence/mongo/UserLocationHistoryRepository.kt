package com.sample.sample.location.adapter.out.persistence.mongo

import org.springframework.data.mongodb.repository.MongoRepository

interface UserLocationHistoryRepository : MongoRepository<UserLocationHistoryEntity, String>
