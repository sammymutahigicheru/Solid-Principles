package com.sammy.solidprinciples

import android.app.Application
import timber.log.Timber

class SolidPrinciples:Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}