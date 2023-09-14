package com.example.shopit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.shopit.databinding.ActivityAddToCartBinding

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
        
    }
}