package com.example.rickandmortyhomeversion.main.repository

import com.example.rickandmortyhomeversion.main.api.InterfaceApi
import com.example.rickandmortyhomeversion.main.models.MainConverter
import com.example.rickandmortyhomeversion.main.models.Result

class MainRemoteRepository(
    private val api: InterfaceApi
) : MainRepository {
    override suspend fun getResult(): List<Result> {
        val data = api.getAllCharacters()
        return MainConverter.fromNetWork(data)
    }

}