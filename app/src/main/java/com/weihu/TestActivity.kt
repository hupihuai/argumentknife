package com.weihu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TestActivity : AppCompatActivity() {

    var name by ActivityArgument("default")
    var num by ActivityArgument(0)

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        textView = findViewById(R.id.textView)
        textView.text = "$name - $num"

    }
}
