package com.example.myapplication.data.source

import com.example.myapplication.data.model.EventDto

interface EventDataSource {
    suspend fun getEvents(): List<EventDto>
    suspend fun getEventDetails(eventId: String): EventDto?
}