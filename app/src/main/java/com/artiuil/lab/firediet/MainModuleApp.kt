package com.artiuil.lab.firediet

import android.app.Application
import com.artiuil.lab.recipiesapi.network.EdamamApiClient

class MainModuleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        EdamamApiClient.setup(
            BuildConfig.BASE_URL,
            BuildConfig.EDAMAM_APP_KEY,
            BuildConfig.EDAMAM_APP_ID
        )
    }
}
