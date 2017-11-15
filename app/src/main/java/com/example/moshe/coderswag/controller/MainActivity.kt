package com.example.moshe.coderswag.controller

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import com.example.moshe.coderswag.R
import com.example.moshe.coderswag.adapters.CategoryAdapter
import com.example.moshe.coderswag.adapters.CategoryRecycleAdapter
import com.example.moshe.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        adapter = CategoryRecycleAdapter(this, DataService.categories)
        categoryListView.adapter = adapter
        categoryListView.layoutManager = LinearLayoutManager(this)
        categoryListView.setHasFixedSize(true)
    }
}
