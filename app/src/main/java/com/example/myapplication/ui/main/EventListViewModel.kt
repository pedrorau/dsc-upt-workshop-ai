package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.myapplication.domain.model.Event
import com.example.myapplication.domain.usecase.GetEventsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventListViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {

    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        loadEvents()
    }

    fun loadEvents() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                _events.value = getEventsUseCase()
            } catch (e: Exception) {
                _error.value = "Error al cargar eventos: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}