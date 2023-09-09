package com.example.shopit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getStringExtra("image")

        binding.atcbtn.setOnClickListener {
            saveDataToDB()
        }




    }

    private fun saveDataToDB() {
        db =FirebaseDatabase.getInstance().reference
        auth = FirebaseAuth.getInstance()
        val currentUserId = auth.currentUser!!.uid.toString()
        val history = HistoryModel()
        db.child(currentUserId).child("History").setValue(binding.txtProNameDetail.text.toString())
    }

}