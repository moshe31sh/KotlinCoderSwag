package com.example.moshe.coderswag

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by moshe on 31/10/2017.
 */

 abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    abstract fun getLayout() : Int

}