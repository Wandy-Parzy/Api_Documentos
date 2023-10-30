package com.example.api_documentos.data.repository

import com.example.api_documentos.data.remote.DocumentosApi
import com.example.api_documentos.data.remote.dto.DocumentosDto
import com.example.api_documentos.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DocumentosRepository @Inject constructor(
    private val api: DocumentosApi
) {
    fun getDocumentos(): Flow<Resource<List<DocumentosDto>>> = flow {
        try {
            emit(Resource.Loading())
            val documento = api.getDocumentos()
            emit(Resource.Success(documento))
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }
}
