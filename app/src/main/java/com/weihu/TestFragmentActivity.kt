package com.weihu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.makeblock.log.preferences.PreferenceArgument

class TestFragmentActivity : AppCompatActivity() {

    private var keystore by PreferenceArgument(this, "keystore", "abc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_fragment)

        keystore = "edf"

        TestFragment.attach(this, R.id.containerLayout)
    }
}
