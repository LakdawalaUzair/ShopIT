package com.example.shopit

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListAdapter(
    private val context: Context,
    private val productList : List<ProductModel>,
) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false)
        return ListViewHolder(layout)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = productList[position]
        holder.proName.text = data.proName
        holder.proPrice.text = data.proPrice
        Glide.with(context).load(data.proImage).into(holder.proImage)

        holder.proImage.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("image", data.proImage)
            context.startActivity(intent)
        }
    }

    class ListViewHolder(binding: View) : RecyclerView.ViewHolder(binding) {
        val proName: TextView = binding.findViewById(R.id.idName_layout)
        val proImage: ImageView = binding.findViewById(R.id.idImage_layout)
        val proPrice: TextView = binding.findViewById(R.id.idPrice_layout)
    }
}
