package com.weihu

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.activityBtn).setOnClickListener {
            TestActivity().apply {
                name = "Come from MainActivity"
                num = 100
                startActivity(this@MainActivity, this)
            }
        }

        findViewById<Button>(R.id.fragmentBtn).setOnClickListener {
            startActivity(this, TestFragmentActivity())
        }
    }
}
