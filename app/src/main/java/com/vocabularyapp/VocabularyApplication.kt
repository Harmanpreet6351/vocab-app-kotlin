package com.vocabularyapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class VocabularyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}