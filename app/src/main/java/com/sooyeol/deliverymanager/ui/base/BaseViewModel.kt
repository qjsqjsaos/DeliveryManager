package com.sooyeol.deliverymanager.ui.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

open class BaseViewModel(application: Application) : AndroidViewModel(application)  {

    val context: Context by lazy {
        getApplication<Application>().applicationContext
    }

}