package com.example.rickandmortyhomeversion.models

import com.google.gson.annotations.SerializedName

data class CharacterData(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val resultsResponse: List<ResultResponse>
)