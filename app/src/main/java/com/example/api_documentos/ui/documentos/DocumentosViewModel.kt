package com.example.api_documentos.ui.documentos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_documentos.data.remote.dto.DocumentosDto
import com.example.api_documentos.data.repository.DocumentosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.api_documentos.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DocumentosListState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val documentos: List<DocumentosDto> = emptyList()
)@HiltViewModel

class DocumentosViewModel @Inject constructor(
    private val documentosRepository: DocumentosRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DocumentosListState())
    val uiState: StateFlow<DocumentosListState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            documentosRepository.getDocumentos().collect() { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.update { it.copy(isLoading = true) }
                    }

                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                documentos = result.data ?: emptyList(),
                                isLoading = false,
                                error = null
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update {
                            it.copy(
                                error = result.message ?: "Error desconocido",
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }
    }
}


