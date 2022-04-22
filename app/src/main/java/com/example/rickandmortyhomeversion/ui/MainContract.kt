package com.example.rickandmortyhomeversion.ui

import com.example.rickandmortyhomeversion.models.CharacterDataResponse


interface MainContract {
    fun showCharacters(data: CharacterDataResponse)
    fun dataFailure(t: Throwable)
}