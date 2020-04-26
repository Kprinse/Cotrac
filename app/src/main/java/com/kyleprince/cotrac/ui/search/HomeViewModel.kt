package com.kyleprince.cotrac.ui.search

import android.widget.ListView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val exampleCountries = mutableListOf<String>(
        "USA", "Mexico", "Austria", "China", "Japan",
        "USA", "Mexico", "Austria", "China", "Japan",
        "USA", "Mexico", "Austria", "China", "Japan",
        "USA", "Mexico", "Austria", "China", "Japan")


    private val _text = MutableLiveData<String>().apply {
        value = "Empty! Search above."
    }
    val text: LiveData<String> = _text
}