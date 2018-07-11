package com.renegens.forgrounddetector.service

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.subjects.PublishSubject

class ForegroundDetector : LifecycleObserver {

    private val subject = PublishSubject.create<Boolean>()

    fun foregroundObservable() = subject

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground() {
        Log.d("TAG", "APP Foreground")
        subject.onNext(true)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground() {
        Log.d("TAG", "APP Background")
        subject.onNext(false)
    }

}