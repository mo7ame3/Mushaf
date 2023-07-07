package com.example.mushaf.network

import com.example.mushaf.model.GetSurah
import retrofit2.http.GET
import retrofit2.http.Path

interface MushafApi {

    @GET("{surahId}")
    suspend fun getSurah(
        @Path("surahId") surahId: String
    ): GetSurah

}