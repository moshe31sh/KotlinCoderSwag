package com.example.moshe.coderswag.controller

import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.moshe.coderswag.R
import com.example.moshe.coderswag.adapters.CategoryAdapter
import com.example.moshe.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        adapter = CategoryAdapter(this, DataService.categories)
        CategoryListView.adapter = adapter
    }
}
