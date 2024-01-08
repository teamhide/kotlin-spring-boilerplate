package com.sample.sample.location.adapter.out.persistence.mongo

import com.sample.sample.common.config.database.BaseTimestampEntity
import com.sample.sample.location.domain.vo.UserLocation
import jakarta.persistence.Id
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "user_location_history")
class UserLocationHistoryEntity(
    @Field(name = "user_id")
    val userId: Long,

    @Field(name = "location")
    val location: UserLocation,

    @Id
    val id: ObjectId = ObjectId(),
) : BaseTimestampEntity()
