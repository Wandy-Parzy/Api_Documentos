package com.example.api_documentos.data.remote

import com.example.api_documentos.data.remote.dto.DocumentosDto
import retrofit2.http.GET

interface DocumentosApi{
    @GET("documentos")
    suspend fun getDocumentos(): List<DocumentosDto>


}