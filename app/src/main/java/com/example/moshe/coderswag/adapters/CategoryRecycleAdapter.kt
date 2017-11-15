package com.example.moshe.coderswag.adapters

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.moshe.coderswag.R
import com.example.moshe.coderswag.model.Category
import com.squareup.picasso.Picasso

/**
 * Created by moshe on 08/11/2017.
 */
class CategoryRecycleAdapter(private val context: Context, private val categories: List<Category>,
                            private val onClickItem: (Category, CardView) -> Unit): RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindCategory(categories[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
            Holder(LayoutInflater.from(context).inflate(R.layout.category_list_row, parent, false), onClickItem)

    override fun getItemCount(): Int = categories.count()


    inner class Holder(itemView: View?, private val onClickItem: (Category, CardView) -> Unit) : RecyclerView.ViewHolder(itemView){
        private val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        private val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)
        private val cardView = itemView?.findViewById<CardView>(R.id.card_view)

        fun bindCategory(category : Category, context: Context){
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
         Picasso.with(context).load(resourceId).into(categoryImage)
            categoryName?.text = category.title
            itemView.setOnClickListener {
                if (cardView != null) {
                    onClickItem(category, cardView)
                }
            }
        }
    }
}