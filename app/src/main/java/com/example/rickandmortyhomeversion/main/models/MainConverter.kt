package com.example.rickandmortyhomeversion.main.models

import com.example.rickandmortyhomeversion.main.api.model.CharacterDataResponse
import com.example.rickandmortyhomeversion.main.api.model.LocationResponse
import com.example.rickandmortyhomeversion.main.api.model.OriginResponse

object MainConverter {
    fun fromNetWork(response: CharacterDataResponse): List<Result> {

        return response.resultsResponse.map { result ->
            Result(
                id = result.id,
                name = result.name,
                status = result.status,
                species = result.species,
                type = result.type,
                gender = result.gender,
                origin = (::fromNetWork),
                location = (::fromNetWork),
                image = result.image,
                episode = result.episode,
                url = result.url,
                created = result.created
            )
        }
    }

    private fun fromNetWork(response: OriginResponse) =
        Origin(
            name = response.name,
            url = response.url
        )

    private fun fromNetWork(response: LocationResponse) =
        Location(
            name = response.name,
            url = response.url
        )
}