package com.example.moshe.coderswag.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.moshe.coderswag.R
import com.example.moshe.coderswag.model.Category

/**
 * Created by moshe on 08/11/2017.
 */
class CategoryRecycleAdapter(private val context: Context, private val categories: List<Category>) :
        RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindCategory(categories[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.category_list_row, parent, false))
    }

    override fun getItemCount(): Int {
        return categories.count()
    }


    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category : Category, context: Context){
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
        }
    }
}