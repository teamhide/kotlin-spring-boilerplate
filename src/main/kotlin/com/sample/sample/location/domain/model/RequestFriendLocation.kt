package com.sample.sample.location.domain.model

import com.sample.sample.location.domain.vo.LocationRequestType

data class RequestFriendLocation(val type: LocationRequestType, val userId: Long)
