package com.sooyeol.deliverymanager.ui.main

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnticipateInterpolator
import androidx.activity.viewModels
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.sooyeol.deliverymanager.R
import com.sooyeol.deliverymanager.databinding.ActivityMainBinding
import com.sooyeol.deliverymanager.ui.base.BaseActivity
import kotlin.concurrent.thread

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main){

    private val vm by viewModels<MainViewModel>()

    override fun init() {
        binding.vm = vm
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        thread(start=true) {
            for (i in 1..2) {
                Thread.sleep(1000)
            }
            vm.setShowSplash(true)
        }

        // Add a callback that's called when the splash screen is animating to
        // the app content.
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            // Create your custom animation.
            val slideUp = ObjectAnimator.ofFloat(
                splashScreenView,
                View.TRANSLATION_Y,
                0f,
                -splashScreenView.height.toFloat()
            )
            slideUp.interpolator = AnticipateInterpolator()
            slideUp.duration = 200L

            // Call SplashScreenView.remove at the end of your custom animation.
            slideUp.doOnEnd { splashScreenView.remove() }

            // Run your animation.
            slideUp.start()
        }
    }

    override fun observer() {
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    // Check if the initial data is ready.
                    return if (vm.showSplash.value!!) {
                        // The content is ready; start drawing.
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        // The content is not ready; suspend.
                        false
                    }
                }
            }
        )
    }

}