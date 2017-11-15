package com.example.moshe.coderswag.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.moshe.coderswag.R
import com.example.moshe.coderswag.model.Product
import com.squareup.picasso.Picasso

/**
 * Created by moshe on 15/11/2017.
 */
class ProductRecycleAdapter(private val context: Context, private val productList: List<Product>) : RecyclerView.Adapter<ProductRecycleAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindProduct(productList[position], context)    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
        Holder(LayoutInflater.from(context).inflate(R.layout.product_list_row, parent, false))


    override fun getItemCount(): Int = productList.count()


    inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView){
        private val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        private val productName = itemView?.findViewById<TextView>(R.id.productName)
        private val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(product: Product, context: Context){
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            Picasso.with(context).load(resourceId).into(productImage)
            productName?.text = product.title
            productPrice?.text = product.price
        }
    }
}


