package com.sooyeol.deliverymanager.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.sooyeol.deliverymanager.R
import com.sooyeol.deliverymanager.ui.splash.SplashActivity

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO:  https://dnight.tistory.com/entry/Android-12-Splash-Screen 스플래시 스크린 참고 후에 12버전 이전에 마이그레이션을 적용하자

    }
}