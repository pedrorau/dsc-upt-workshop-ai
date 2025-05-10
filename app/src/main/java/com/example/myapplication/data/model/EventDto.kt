package com.example.myapplication.data.model

data class EventDto(
    val id: String,
    val name: String,
    val city: String,
    val address: String,
    val type: String, // "presencial" or "remoto"
    val startTime: String,
    val endTime: String
)
