package com.weihu

import android.app.Activity
import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.support.v4.app.BundleCompat
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * created by hupihuai on 2018/10/30
 */

class ActivityArgument<T : Any>(private val default: T? = null) : ReadWriteProperty<Activity, T> {

    var value: T? = null

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): T {
        if (value == null) {
            val args = thisRef.intent.extras
                ?: throw IllegalStateException("Cannot read property ${property.name} if no arguments have been set")
            if (args.containsKey(property.name)) {
                @Suppress("UNCHECKED_CAST")
                value = args.get(property.name) as T
            } else {
                value = default
            }
        }
        return value ?: throw IllegalStateException("Property ${property.name} could not be read")
    }


    override operator fun setValue(thisRef: Activity, property: KProperty<*>, value: T) {

        var intent = IntentInstanceManager.getIntent(thisRef)
        if (intent == null) {
            intent = Intent().apply {
                putExtras(Bundle())
            }
            IntentInstanceManager.putIntent(thisRef, intent)
        }

        val args = intent.extras
        val key = property.name
        when (value) {
            is String -> args.putString(key, value)
            is Int -> args.putInt(key, value)
            is Short -> args.putShort(key, value)
            is Long -> args.putLong(key, value)
            is Byte -> args.putByte(key, value)
            is ByteArray -> args.putByteArray(key, value)
            is Char -> args.putChar(key, value)
            is CharArray -> args.putCharArray(key, value)
            is CharSequence -> args.putCharSequence(key, value)
            is Float -> args.putFloat(key, value)
            is Bundle -> args.putBundle(key, value)
            is Binder -> BundleCompat.putBinder(args, key, value)
            is android.os.Parcelable -> args.putParcelable(key, value)
            is java.io.Serializable -> args.putSerializable(key, value)
            else -> throw IllegalStateException("Type ${value.javaClass.canonicalName} of property ${property.name} is not supported")
        }
        intent.putExtras(args)
    }
}