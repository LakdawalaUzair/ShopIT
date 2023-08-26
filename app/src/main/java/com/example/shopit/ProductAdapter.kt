package com.example.shopit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RemoteViews.RemoteView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val context : Context,private var productList : List<ProductModel>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(binding : View) : RecyclerView.ViewHolder(binding){

        val proName : TextView = binding.findViewById(R.id.idProName_layout)
        val proImage : ImageView = binding.findViewById(R.id.idProductImage_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.main_layout,parent,false)

        return ProductViewHolder(layout)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(binding: ProductViewHolder, position: Int) {
        binding.proName.text = productList[position].proName
        binding.itemView.setOnClickListener {
            val intent = Intent(context,ListActivity::class.java)
            intent.putExtra("name",productList[position].proName)
            context.startActivity(intent)
        }
        binding.proImage.setImageResource(productList[position].proImage!!)

    }
}