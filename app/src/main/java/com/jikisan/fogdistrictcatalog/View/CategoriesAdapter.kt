package com.jikisan.fogdistrictcatalog.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jikisan.fogdistrictcatalog.Model.CategoriesModel
import com.jikisan.fogdistrictcatalog.R

class CategoriesAdapter(private val categories: List<CategoriesModel>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categories, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = categories.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(categories[position].image)
        holder.textView.setText(categories[position].name)
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_catImage)
        val textView: TextView = itemView.findViewById(R.id.tv_catName)
    }

}