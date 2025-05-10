package com.example.myapplication.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.myapplication.domain.model.Event
import com.example.myapplication.domain.usecase.GetEventDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getEventDetailsUseCase: GetEventDetailsUseCase
) : ViewModel() {

    private val eventId: String = checkNotNull(savedStateHandle["eventId"])

    private val _event = MutableStateFlow<Event?>(null)
    val event: StateFlow<Event?> = _event

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        loadEventDetails()
    }

    private fun loadEventDetails() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                _event.value = getEventDetailsUseCase(eventId)
            } catch (e: Exception) {
                _error.value = "Error al cargar detalles del evento: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}