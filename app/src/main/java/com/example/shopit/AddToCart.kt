package com.example.shopit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopit.admin.AddProductModel
import com.example.shopit.databinding.ActivityAddToCartBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AddToCart : AppCompatActivity() {
    private lateinit var binding : ActivityAddToCartBinding

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.dots -> {
                startActivity(Intent(this, AddToCart::class.java))

            }
            R.id.add -> {
                startActivity(Intent(this, AdminActivity::class.java))
            }
        }
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityAddToCartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getDataFromDB()
    }

    private fun getDataFromDB() {
        val db = FirebaseDatabase.getInstance()
        val currentUserId = FirebaseAuth.getInstance().currentUser!!.uid
        val historyRef = db.getReference("History").child(currentUserId)

        historyRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val proList = mutableListOf<AddProductModel>()
                for (childSnapshot in snapshot.children) {
                    val productModel = childSnapshot.getValue(AddProductModel::class.java)
                    if (productModel != null) {
                        proList.add(productModel)
                    }
                    setRecyclerView(proList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })


    }
    private fun setRecyclerView(proList: List<AddProductModel>) {
        binding.rv.layoutManager = LinearLayoutManager(this@AddToCart)
        binding.rv.adapter =  ListAdapter(this@AddToCart, proList ,"fgjd")
    }
}