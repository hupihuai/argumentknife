package com.weihu

import android.app.Activity
import android.content.Intent

/**
 * created by hupihuai on 2019/2/20
 */

fun Activity.startActivity(activity: Activity, nextActivity: Activity) {
    ActivityInstanceManager.putActivity(nextActivity)
    activity.startActivity(createIntent(activity, nextActivity))
}

fun Activity.startActivityForResult(activity: Activity, nextActivity: Activity, requestCode: Int) {
    ActivityInstanceManager.putActivity(nextActivity)
    activity.startActivityForResult(createIntent(activity, nextActivity), requestCode)
}

private fun createIntent(activity: Activity, nextActivity: Activity): Intent {
    val intent = IntentInstanceManager.getIntentAndRemove(nextActivity) ?: Intent()
    intent.setClass(activity, nextActivity::class.java)
    return intent
}

