package com.renegens.forgrounddetector.injection

import android.content.Context
import com.renegens.forgrounddetector.App
import com.renegens.forgrounddetector.service.ForegroundDetector
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    fun provideApplication() = context as App

    @Provides
    @Singleton
    fun provideForegroundDetector() = ForegroundDetector()

}