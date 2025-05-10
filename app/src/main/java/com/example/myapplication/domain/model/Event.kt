package com.example.myapplication.domain.model

data class Event(
    val id: String,
    val name: String,
    val city: String,
    val address: String,
    val type: EventType,
    val startTime: String, // Puedes usar tipos de fecha/hora más robustos si es necesario
    val endTime: String
)

enum class EventType {
    PRESENCIAL, REMOTO
}
