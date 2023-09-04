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

class ListAdapter(
    private val context: Context,
    private val proImage: List<Int>,
    private val proName: List<String>,
    private val productPrice: List<String>
) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false)
        return ListViewHolder(layout)
    }

    override fun getItemCount() = proName.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.proName.text = proName[position]
        holder.proPrice.text = productPrice[position]
        holder.proImage.setImageResource(proImage[position])


        holder.proImage.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("image", proName[position])
            //Log.d("tufel", "Product name: ${proName[position]}")
            context.startActivity(intent)
        }
    }

    class ListViewHolder(binding: View) : RecyclerView.ViewHolder(binding) {
        val proName: TextView = binding.findViewById(R.id.idName_layout)
        val proImage: ImageView = binding.findViewById(R.id.idImage_layout)
        val proPrice: TextView = binding.findViewById(R.id.idPrice_layout)
    }
}
