package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.mapper.toDomain
import com.example.myapplication.domain.model.Event
import com.example.myapplication.domain.repository.EventRepository
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val eventRepository: EventRepository
){
    suspend operator fun invoke(): List<Event> {
        return eventRepository.getEvents().map { it.toDomain() }
    }
}