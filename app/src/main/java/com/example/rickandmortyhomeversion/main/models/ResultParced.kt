package com.example.rickandmortyhomeversion.main.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultParced(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val created: String
) : Parcelable