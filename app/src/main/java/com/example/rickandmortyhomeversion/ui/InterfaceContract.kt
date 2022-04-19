package com.example.rickandmortyhomeversion.ui

import com.example.rickandmortyhomeversion.models.CharacterData


interface InterfaceContract{
    fun showCharacters(data: CharacterData)
    fun dataFailure(t: Throwable)
}