package com.jikisan.fogdistrictcatalog.View

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jikisan.fogdistrictcatalog.Model.VapeProductModel
import com.jikisan.fogdistrictcatalog.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class ProductsAdapter(private val context: Context, private val products: ArrayList<VapeProductModel>):
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>(){

    @SuppressLint("NotifyDataSetChanged")
    fun updateProductList(newProductList : List<VapeProductModel>){
        products.clear()
        products.addAll(newProductList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_products, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = products[position]

        Picasso.get()
            .load(product.image)
            .into(holder.iv_productImage, object : Callback {
                override fun onSuccess() {
                    Log.d("Picasso", "Image loaded successfully")
                }

                override fun onError(e: Exception?) {
                    Log.e("Picasso", "Error loading image: ${e?.message}")
                }
            })

//        Glide.with(context)
//            .load(product.image)
//            .fitCenter()
//            .centerCrop()
//            .into(holder.iv_productImage)

        holder.tv_productName.text = product.name

        val price = "${context.getString(R.string.peso_sign)}${product.price}"
        holder.tv_productPrice.text = price

        val quantity = "Quantity: ${product.quantity}"
        holder.tv_quantity.text = quantity

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv_productImage : ImageView = itemView.findViewById(R.id.iv_productsImage)
        val tv_productName : TextView = itemView.findViewById(R.id.tv_productName)
        val tv_productPrice : TextView = itemView.findViewById(R.id.tv_productPrice)
        val tv_quantity : TextView = itemView.findViewById(R.id.tv_quantity)
    }
}