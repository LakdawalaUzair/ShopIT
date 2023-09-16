package com.example.shopit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopit.admin.AddProductModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ListAdapter(
    private val context: Context,
    private val productList : List<AddProductModel>,
    private val who : String
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
        if(who.equals("list")) {
            holder.cbCart.isVisible = false
        }else{
            holder.cbCart.isVisible = true
            holder.cbCart.isChecked = true
        }
        holder.cbCart.setOnCheckedChangeListener { _, isChecked ->

                removeCartItem(position)


        }
        Glide.with(context).load(data.proImage).into(holder.proImage)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("pname", data.proName)
            intent.putExtra("pimg", data.proImage)
            intent.putExtra("pdes", data.proDes)
            intent.putExtra("pprice", data.proPrice)
            context.startActivity(intent)
        }
    }

    private fun removeCartItem(position: Int) {
        val data = productList[position]
        val db =FirebaseDatabase.getInstance().reference
        val auth = FirebaseAuth.getInstance()
        val currentUserId = auth.currentUser!!.uid.toString()
        db.child("History").child(currentUserId).child(data.proName).removeValue()
            .addOnSuccessListener {
            }
            .addOnFailureListener {
                Toast.makeText(context,"Somthing went wrong !!!",Toast.LENGTH_SHORT).show()
            }
    }

    private fun addCartItem(position: Int) {
        val data = productList[position]
        val db = FirebaseDatabase.getInstance().reference
        val auth = FirebaseAuth.getInstance()
        val currentUserId = auth.currentUser!!.uid.toString()
        val history = AddProductModel(data.proName,data.proImage,data.proPrice,data.proDes)
        db.child("History").child(currentUserId).child(data.proName).setValue(history)
            .addOnSuccessListener {
                Toast.makeText(context,data.proName +" Added in cart", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(context,"Somthing went wrong !!!", Toast.LENGTH_SHORT).show()
            }
    }

    class ListViewHolder(binding: View) : RecyclerView.ViewHolder(binding) {
        val proName: TextView = binding.findViewById(R.id.idName_layout)
        val proImage: ImageView = binding.findViewById(R.id.idImage_layout)
        val proPrice: TextView = binding.findViewById(R.id.idPrice_layout)
        val cbCart: CheckBox= binding.findViewById(R.id.idCBCart_layout)
    }
}
