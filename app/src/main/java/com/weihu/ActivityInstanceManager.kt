package com.weihu

import android.app.Activity

/**
 * created by hupihuai on 2019/2/20
 */
object ActivityInstanceManager {

    private val activityMap = HashMap<Class<*>, Activity>()

    fun putActivity(activity: Activity) {
        activityMap[activity.javaClass] = activity
    }

    fun getActivity(clazz: Class<*>): Activity? {
        return activityMap.remove(clazz)
    }

}