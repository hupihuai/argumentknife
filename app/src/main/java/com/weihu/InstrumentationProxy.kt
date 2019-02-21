package com.weihu

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent

/**
 * created by hupihuai on 2019/2/20
 */
class InstrumentationProxy(val mInstrumentation: Instrumentation) : Instrumentation() {

    override fun newActivity(cl: ClassLoader?, className: String?, intent: Intent?): Activity {
        println("className = ${className}")
        val clazz = Class.forName(className)
        return ActivityInstanceManager.getActivity(clazz) ?: super.newActivity(cl, className, intent)
    }
}