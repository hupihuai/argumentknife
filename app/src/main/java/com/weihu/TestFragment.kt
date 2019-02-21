package com.weihu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * created by hupihuai on 2019/2/21
 */
class TestFragment : Fragment() {

    companion object {
        fun attach(act: FragmentActivity, containerId: Int) {
            val fragment = TestFragment().apply {
                age = 18
                name = "小花"
            }
            act.supportFragmentManager.beginTransaction().replace(containerId, fragment).commit()
        }
    }

    var name by FragmentArgument("lily")
    var age by FragmentArgument(16)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val textView = view!!.findViewById<TextView>(R.id.contentTv)
        textView.text = "$name - $age"
    }


}