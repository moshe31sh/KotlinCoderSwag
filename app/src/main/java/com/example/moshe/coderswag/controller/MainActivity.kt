package com.example.moshe.coderswag.controller

import android.content.Intent
import android.os.Build
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutManager
import com.example.moshe.coderswag.R
import com.example.moshe.coderswag.adapters.CategoryRecycleAdapter
import com.example.moshe.coderswag.services.DataService
import com.example.moshe.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var adapter: CategoryRecycleAdapter

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        adapter = CategoryRecycleAdapter(this, DataService.categories){
            category, cardView ->
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY , category)
            val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, cardView, "category")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                startActivity(intent, activityOptionsCompat.toBundle())
            }
        }
        categoryListView.adapter = adapter
        categoryListView.layoutManager = LinearLayoutManager(this)
        categoryListView.setHasFixedSize(true)
    }
}
