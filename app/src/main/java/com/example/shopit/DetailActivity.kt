package com.example.shopit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.shopit.admin.AddProductModel
import com.example.shopit.databinding.ActivityDetailBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var db : DatabaseReference
    private lateinit var auth : FirebaseAuth



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
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val proName = intent.getStringExtra("pname")!!
        val proImage =  intent.getStringExtra("pimg")!!
        val proDes = intent.getStringExtra("pdes")!!
        val proPrice = intent.getStringExtra("pprice")!!

        //binding.txtdesc.text = proName

        binding.txtProNameDetail.text = proName
        Glide.with(this@DetailActivity).load(proImage).into(binding.proImageDetail)
        binding.txtProPriceDetail.text = proPrice
        binding.txtDesDet.text = proDes

        binding.atcbtn.setOnClickListener {
            saveDataToDB()

        }

        binding.btnback.setOnClickListener {
            onBackPressed()
        }



    }

    private fun saveDataToDB() {
        val proName = intent.getStringExtra("pname")!!
        val proImage =  intent.getStringExtra("pimg")!!
        val proDes = intent.getStringExtra("pdes")!!
        val proPrice = intent.getStringExtra("pprice")!!
        db =FirebaseDatabase.getInstance().reference
        auth = FirebaseAuth.getInstance()
        val currentUserId = auth.currentUser!!.uid.toString()
        val history = AddProductModel(proName,proImage,proPrice,proDes)
        db.child("History").child(currentUserId).child(proName).setValue(history)
                .addOnSuccessListener {
                    Toast.makeText(this@DetailActivity,proName +" Added in cart", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this@DetailActivity,"Somthing went wrong !!!",Toast.LENGTH_SHORT).show()
                }
    }

}