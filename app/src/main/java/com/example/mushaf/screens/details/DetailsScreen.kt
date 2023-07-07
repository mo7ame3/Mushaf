package com.example.mushaf.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mushaf.data.WrapperClass
import com.example.mushaf.model.Ayah
import com.example.mushaf.model.GetSurah

@Composable
fun DetailsScreen(
    detailsViewModel: DetailsViewModel,
    surahId: String,
) {
    var loading by remember {
        mutableStateOf(true)
    }

    val produce =
        produceState<WrapperClass<GetSurah, Boolean, Exception>>(initialValue = WrapperClass()) {
            value = detailsViewModel.getSurah(surahId = surahId)
        }.value
    if (produce.data?.code == 200) {
        loading = false
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        if (loading) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(produce.data?.data!!.ayahs) {
                    CardSurah(item = it)
                }
            }
        }
    }
}


@Composable
fun CardSurah(
    item: Ayah
) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (item.text == "بِسۡمِ ٱللَّهِ ٱلرَّحۡمَـٰنِ ٱلرَّحِیمِ") {
                Text(text = item.text, style = MaterialTheme.typography.bodyMedium)
            } else {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = " ${item.numberInSurah}  ",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = item.text,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }

}
