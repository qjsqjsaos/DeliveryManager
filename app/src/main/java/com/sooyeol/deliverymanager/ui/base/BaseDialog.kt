package com.sooyeol.deliverymanager.ui.base

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.sooyeol.deliverymanager.ui.dialog.listener.DialogClickListener


abstract class BaseDialog<T : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int,
    var listener: DialogClickListener
    ) : DialogFragment() {

    protected lateinit var binding: T
    protected var params: ViewGroup.LayoutParams? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)!!
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val view = binding.root
        init()
        return view
    }

    fun positive() {
        dismiss()
        listener.positiveClicked()
    }

    fun negative() {
        dismiss()
    }

    //사이즈 비율대로 조절하는 법
    // 이건 가로만 비율 조절
    fun sizeAdjustment() {
        params = dialog?.window?.attributes
        val deviceWidth = Resources.getSystem().displayMetrics.widthPixels
        params?.width = (deviceWidth * 0.9).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

    //이것도 비율조절이 가능하나 가로세로 둘다 한다/
    fun sizeAdjustment2(widthRatio: Double = 0.9, heightRatio: Double = 0.8) {
        params = dialog?.window?.attributes
        val deviceWidth = Resources.getSystem().displayMetrics.widthPixels
        val deviceHeight = Resources.getSystem().displayMetrics.heightPixels
        params?.width = (deviceWidth * widthRatio).toInt()
        params?.height = (deviceHeight * heightRatio).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

    //직접 사이즈를 넣는 방법
    fun passivitySize(widthSize: Int, heightSize: Int) {
        val width = resources.getDimensionPixelSize(widthSize)
        val height = resources.getDimensionPixelSize(heightSize)
        dialog?.window?.setLayout(width, height)
    }

    abstract fun init()
}