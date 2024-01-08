package com.sample.sample.location.domain.model

import com.sample.sample.location.domain.vo.LocationRequestType

data class UpdateUserLocation(
    val type: LocationRequestType,
    val userId: Long,
    val lat: Double,
    val lng: Double,
)
