package com.example.mushaf.screens.details

import androidx.lifecycle.ViewModel
import com.example.mushaf.data.WrapperClass
import com.example.mushaf.model.GetSurah
import com.example.mushaf.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    suspend fun getSurah(surahId: String): WrapperClass<GetSurah, Boolean, Exception> {
        return repository.getSurah(surahId = surahId)
    }

}