package com.example.splashscreen.data.model

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    companion object {
        lateinit var instance: MyApplication

        fun getAppContext(): Context {
            return instance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this // Asegúrate de inicializar aquí.
    }
}
