package com.example.api_documentos.di

import com.example.api_documentos.data.remote.DocumentosApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Singleton
    @Provides
    fun providesDocumentosApi(moshi: Moshi): DocumentosApi {
        return Retrofit.Builder().baseUrl("https://my-json-server.typicode.com/enelramon/apimock/")
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
            .create(DocumentosApi::class.java)
    }
}