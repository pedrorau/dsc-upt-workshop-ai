package com.example.myapplication.domain.repository

import com.example.myapplication.data.model.EventDto
import com.example.myapplication.data.source.EventDataSource
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val eventDataSource: EventDataSource // Inyectaremos MockEventDataSource aquí
) {
    suspend fun getEvents(): List<EventDto> {
        return eventDataSource.getEvents()
    }

    suspend fun getEventDetails(eventId: String): EventDto? {
        return eventDataSource.getEventDetails(eventId)
    }
}