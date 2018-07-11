package com.renegens.forgrounddetector.injection

import javax.inject.Singleton

@Singleton
@dagger.Component(modules = arrayOf(
        ApplicationModule::class
))
interface ApplicationComponent: Component