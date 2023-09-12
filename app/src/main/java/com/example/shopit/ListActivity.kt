package com.example.shopit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopit.databinding.ActivityListBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListBinding

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.dots->{
                startActivity(Intent(this,AddToCart::class.java))

            }
        }
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productName = intent.getStringExtra("name")

        getDataFromFirebase(productName!!)
    }


    private fun getDataFromFirebase(productName: String) {
        val proList = ArrayList<ProductModel>()
        val db = FirebaseDatabase.getInstance().reference.child("Products").child(productName)
        try {
            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (i in snapshot.children) {
                        val produtModel = i.getValue(ProductModel::class.java)
                        proList.add(produtModel!!)
                    }
                    setRecyclerView(proList)
                }

                override fun onCancelled(error: DatabaseError) {

                    Toast.makeText(this@ListActivity,error.message.toString(),Toast.LENGTH_SHORT).show()
                }

            })
        }catch (e : Exception){
            Log.d("Tufel",e.message.toString())
            Toast.makeText(this@ListActivity,e.message.toString(),Toast.LENGTH_SHORT).show()
        }

    }

    private fun setRecyclerView(proList: ArrayList<ProductModel>) {
        binding.listRecyclerView.layoutManager = LinearLayoutManager(this@ListActivity)
        binding.listRecyclerView.adapter =  ListAdapter(this@ListActivity, proList )

    }
}