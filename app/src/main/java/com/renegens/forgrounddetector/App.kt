package com.renegens.forgrounddetector

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.renegens.forgrounddetector.injection.ApplicationModule
import com.renegens.forgrounddetector.injection.Component
import com.renegens.forgrounddetector.injection.DaggerApplicationComponent
import com.renegens.forgrounddetector.service.ForegroundDetector
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var foregroundDetector: ForegroundDetector

    private lateinit var component: Component


    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build().apply {
                    inject(this@App)
                }

        ProcessLifecycleOwner.get()
                .lifecycle
                .addObserver(foregroundDetector)

    }

    fun getComponent() = component

}