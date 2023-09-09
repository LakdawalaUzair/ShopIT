package com.example.shopit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopit.databinding.ActivityAddToCartBinding

class AddToCart : AppCompatActivity() {
    private lateinit var binding : ActivityAddToCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityAddToCartBinding.inflate(layoutInflater)
        setContentView(binding.root)



        getDataFromDB()
    }

    private fun getDataFromDB() {
        
    }
}