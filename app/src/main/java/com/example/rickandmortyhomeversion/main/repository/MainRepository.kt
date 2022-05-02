package com.example.rickandmortyhomeversion.main.repository

import com.example.rickandmortyhomeversion.main.models.Result

interface MainRepository {
    suspend fun getResult():List<Result>
}