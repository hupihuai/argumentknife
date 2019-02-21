package com.weihu

import android.app.Application
import android.app.Instrumentation

import java.lang.reflect.Field

/**
 * created by hupihuai on 2019/2/20
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        hookActivityThreadInstrumentation()
    }

    private fun hookActivityThreadInstrumentation() {
        try {
            val activityThreadClazz = Class.forName("android.app.ActivityThread")
            val activityThreadField = activityThreadClazz.getDeclaredField("sCurrentActivityThread")
            activityThreadField.isAccessible = true
            val activityThread = activityThreadField.get(null)
            val instrumentationField = activityThreadClazz.getDeclaredField("mInstrumentation")
            instrumentationField.isAccessible = true
            val instrumentation = instrumentationField.get(activityThread) as Instrumentation
            val proxy = InstrumentationProxy(instrumentation)
            instrumentationField.set(activityThread, proxy)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
