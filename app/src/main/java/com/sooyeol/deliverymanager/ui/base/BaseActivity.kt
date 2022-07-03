package com.sooyeol.deliverymanager.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T: ViewDataBinding>(@LayoutRes private val layoutResId: Int) : AppCompatActivity() {


    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        init()
        clickListener()
        observer()
    }

    protected fun shortShowToast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    protected fun longShowToast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

    open fun observer() {
    }

    open fun clickListener() {
    }

    abstract fun init()


}