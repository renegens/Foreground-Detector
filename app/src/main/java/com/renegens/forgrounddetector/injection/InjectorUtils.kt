package com.renegens.forgrounddetector.injection


import android.app.Activity
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.renegens.forgrounddetector.App

fun Context.getDagger() = (applicationContext as App).getComponent()

fun Activity.getDagger() = (application as App).getComponent()

fun Fragment.getDagger() = (this.context?.applicationContext as App).getComponent()

fun View.getDagger() = (this.context.applicationContext as App).getComponent()
