package com.sooyeol.deliverymanager.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _showSplash = MutableLiveData(true)

    val showSplash: LiveData<Boolean> = _showSplash

    fun setShowSplash(bool: Boolean) = _showSplash.postValue(bool)

    val clickListener = MutableLiveData<String>()
    fun onClick(type: String) {
        clickListener.value = type
    }
}