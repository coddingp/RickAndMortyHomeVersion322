package com.example.rickandmortyhomeversion.main.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmortyhomeversion.main.models.Info
import com.example.rickandmortyhomeversion.main.models.ResultParced

@Entity(tableName = "Characters_data")
data class EntityData(
    @PrimaryKey(autoGenerate = true) val ChId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "species") val species: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "created") val created: String,
)