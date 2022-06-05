package com.example.rickandmortyhomeversion.common

import com.example.rickandmortyhomeversion.R
import com.example.rickandmortyhomeversion.main.api.InterfaceApi
import com.example.rickandmortyhomeversion.utils.Utils
import com.example.rickandmortyhomeversion.utils.Utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommonModule {
    fun createRetrofit() = module {
        single {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(InterfaceApi::class.java)
        }
    }
}