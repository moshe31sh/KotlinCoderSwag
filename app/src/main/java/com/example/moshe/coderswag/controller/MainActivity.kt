package com.example.moshe.coderswag.controller

import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.moshe.coderswag.R
import com.example.moshe.coderswag.model.Category
import com.example.moshe.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var adapter: ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, DataService.categories)
        CategoryListView.adapter = adapter
    }
}
