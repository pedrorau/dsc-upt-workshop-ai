package com.example.myapplication.data.source

import com.example.myapplication.data.model.EventDto

class MockEventDataSource: EventDataSource {

    private val mockEvents = listOf(
        EventDto(
            id = "1",
            name = "Concierto de Rock Alternativo",
            city = "Madrid",
            address = "Sala La Riviera, Paseo Bajo de la Virgen del Puerto, s/n",
            type = "presencial",
            startTime = "2023-10-27T21:00:00Z",
            endTime = "2023-10-27T23:00:00Z"
        ),
        EventDto(
            id = "2",
            name = "Festival de Indie Folk Online",
            city = "Barcelona", // Aunque sea remoto, indicamos una ciudad de referencia
            address = "Plataforma de streaming online",
            type = "remoto",
            startTime = "2023-11-10T19:00:00Z",
            endTime = "2023-11-10T22:00:00Z"
        ),
        EventDto(
            id = "3",
            name = "Noche de Jazz en Vivo",
            city = "Sevilla",
            address = "Café Jazz Naima, Calle Trajano, 57",
            type = "presencial",
            startTime = "2023-11-20T20:30:00Z",
            endTime = "2023-11-20T23:00:00Z"
        )
    )

    override suspend fun getEvents(): List<EventDto> {
        // Simulate network delay
        kotlinx.coroutines.delay(500)
        return mockEvents
    }

    override suspend fun getEventDetails(eventId: String): EventDto? {
        // Simulate network delay
        kotlinx.coroutines.delay(300)
        return mockEvents.find { it.id == eventId }
    }
}