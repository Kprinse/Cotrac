package com.kyleprince.cotrac.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.kyleprince.cotrac.MySingleton

class HomeViewModel : ViewModel() {


    // Access the RequestQueue through your singleton class.
    val countryList = mutableListOf<String>("USA", "Russia")

    fun updateCountryList() {
        countryList.clear()
    }


    private val _text = MutableLiveData<String>().apply {
        value = "Empty! Search above."
    }
    val text: LiveData<String> = _text
}