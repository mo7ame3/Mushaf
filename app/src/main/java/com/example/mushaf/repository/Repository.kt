package com.example.mushaf.repository

import android.util.Log
import com.example.mushaf.data.WrapperClass
import com.example.mushaf.model.GetSurah
import com.example.mushaf.network.MushafApi
import javax.inject.Inject

class Repository @Inject constructor(private val api: MushafApi) {

    private val getSurah = WrapperClass<GetSurah , Boolean , Exception> ()

    suspend fun getSurah(surahId :String) : WrapperClass<GetSurah , Boolean , Exception>{
        try {
            getSurah.data = api.getSurah(surahId = surahId)
        } catch (e: Exception) {
            //addNewUser.loading = false
            Log.d("TAG", "getSurah: $e")
            getSurah.e = e
        }
        return getSurah
    }

}