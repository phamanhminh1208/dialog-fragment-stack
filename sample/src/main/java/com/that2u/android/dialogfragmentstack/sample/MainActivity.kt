package com.that2u.android.dialogfragmentstack.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.that2u.android.dialogfragmentstack.DialogFragmentStack

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        var dialog1: DialogFragment1 = DialogFragment1()
        var dialog2: DialogFragment2 = DialogFragment2()
        var dialog3: DialogFragment1 = DialogFragment1()

        var dialogStack: DialogFragmentStack = DialogFragmentStack()

        dialogStack.show(fragmentManager, dialog1)
        dialogStack.show(fragmentManager, dialog2)
        //dialogStack.show(fragmentManager, dialog3)
    }
}
