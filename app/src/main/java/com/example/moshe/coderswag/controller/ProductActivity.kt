package com.example.moshe.coderswag.controller

import com.example.moshe.coderswag.R
import com.example.moshe.coderswag.model.Category
import com.example.moshe.coderswag.utilities.EXTRA_CATEGORY
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_product

    override fun initView() {
        val category = intent.getParcelableExtra<Category>(EXTRA_CATEGORY)
        categoryName.text = category.title
        val resourceId = resources.getIdentifier(category.image, "drawable", packageName)
        Picasso.with(this).load(resourceId).into(categoryImage)
    }
}
