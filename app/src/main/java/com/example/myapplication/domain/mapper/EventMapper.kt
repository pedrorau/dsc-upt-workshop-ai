package com.example.myapplication.domain.mapper

import com.example.myapplication.data.model.EventDto
import com.example.myapplication.domain.model.Event
import com.example.myapplication.domain.model.EventType

fun EventDto.toDomain(): Event {
    return Event(
        id = id,
        name = name,
        city = city,
        address = address,
        type = when (type) {
            "presencial" -> EventType.PRESENCIAL
            "remoto" -> EventType.REMOTO
            else -> EventType.PRESENCIAL // Default o manejar error
        },
        startTime = startTime,
        endTime = endTime
    )
}