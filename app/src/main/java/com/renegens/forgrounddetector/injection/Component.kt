package com.renegens.forgrounddetector.injection

import com.renegens.forgrounddetector.App
import com.renegens.forgrounddetector.ui.MainActivity

interface Component {

    //App

    fun inject(app: App)

    //Activity

    fun inject(activity: MainActivity)

}