package com.kyleprince.cotrac.ui.search

import android.widget.ListView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val countryList = mutableListOf<String>("USA", "Mexico", "Austria", "China")

    fun updateCountryList() {
        countryList.clear()
    }


    private val _text = MutableLiveData<String>().apply {
        value = "Empty! Search above."
    }
    val text: LiveData<String> = _text
}