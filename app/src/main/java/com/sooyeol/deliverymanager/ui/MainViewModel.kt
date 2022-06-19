package com.sooyeol.deliverymanager.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _complete = MutableLiveData<Boolean>()
    val complete: LiveData<Boolean> get() = _complete

    init {
        _complete.value = false
    }

    fun updateComplete(){
        _complete.value = true
    }
}