package com.example.moshe.coderswag.controller

import android.content.res.Configuration
import android.support.v7.widget.GridLayoutManager
import com.example.moshe.coderswag.R
import com.example.moshe.coderswag.adapters.ProductRecycleAdapter
import com.example.moshe.coderswag.model.Category
import com.example.moshe.coderswag.services.DataService
import com.example.moshe.coderswag.utilities.EXTRA_CATEGORY
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : BaseActivity() {

    private lateinit var adapter: ProductRecycleAdapter

    override fun getLayout(): Int = R.layout.activity_product

    override fun initView() {
        val category = intent.getParcelableExtra<Category>(EXTRA_CATEGORY)
        categoryName.text = category.title
        val resourceId = resources.getIdentifier(category.image, "drawable", packageName)

        var spanCount = 2
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 4
        }
        if(resources.configuration.screenHeightDp > 720){
            spanCount = 3
        }

        Picasso.with(this).load(resourceId).into(categoryImage)
        adapter = ProductRecycleAdapter(this, DataService.getProduct(category.title))
        productListView.adapter = adapter
        productListView.layoutManager = GridLayoutManager(this, spanCount)
        productListView.setHasFixedSize(true)

    }
}
