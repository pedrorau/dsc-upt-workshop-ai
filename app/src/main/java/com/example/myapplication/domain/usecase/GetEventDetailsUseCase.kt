package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.mapper.toDomain
import com.example.myapplication.domain.model.Event
import javax.inject.Inject
import com.example.myapplication.domain.repository.EventRepository

class GetEventDetailsUseCase @Inject constructor(
    private val eventRepository: EventRepository
){
    suspend operator fun invoke(eventId: String): Event? {
        return eventRepository.getEventDetails(eventId)?.toDomain()
    }
}