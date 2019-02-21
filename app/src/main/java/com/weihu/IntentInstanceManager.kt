package com.weihu

import android.app.Activity
import android.content.Intent

/**
 * created by hupihuai on 2019/2/20
 */
object IntentInstanceManager {
    private val intentMap = HashMap<Activity, Intent>()
    fun putIntent(activity: Activity, intent: Intent) {
        intentMap[activity] = intent
    }

    fun getIntent(activity: Activity): Intent? {
        return intentMap[activity]
    }

    fun getIntentAndRemove(activity: Activity): Intent? {
        return intentMap.remove(activity)
    }

    fun removeIntent(activity: Activity) {
        intentMap.remove(activity)
    }
}