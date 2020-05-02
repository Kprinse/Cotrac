package com.kyleprince.cotrac.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel() {

    val newsList = mutableListOf<String>("Click the button to populate feed")

    private val _text = MutableLiveData<String>().apply {
        value = "The News Portion of the app"
    }
    val text: LiveData<String> = _text
}