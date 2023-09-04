package com.example.shopit.admin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.shopit.databinding.ActivityAdminBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlin.random.Random

class AdminActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAdminBinding
    private lateinit var imgUri : Uri
    private var auth = FirebaseAuth.getInstance()
    private lateinit var db : FirebaseDatabase
    private lateinit var selectedCategory : String

    val categories = arrayOf("Laptop", "Charger", "Desktop Monitor", "Desktop", "Mouse", "Keyboard", "Printer", "Motherboard", "Anti-Virus", "Router Switches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgSelectProduct.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent,100)
        }

        binding.proCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedCategory = categories[position]


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case where nothing is selected
            }
        }

        binding.btnAddProduct.setOnClickListener {
            val proName = binding.etProductName.text.toString()
            val proPrice = binding.etProductPrice.text.toString()
            val proDes = binding.etDesProdct.text.toString()

            if(proName.isNotEmpty() && proPrice.isNotEmpty() && proDes.isNotEmpty() && imgUri!=null){
                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.proCategory.adapter = adapter

                saveData2Database(proName,proPrice,proDes,imgUri,selectedCategory)
            }else{
                Toast.makeText(this@AdminActivity,"Pleas enter all details",Toast.LENGTH_SHORT).show()
            }
            }
    }

    private fun saveData2Database(
        proName: String,
        proPrice: String,
        proDes: String,
        imgUri: Uri,
        selectedCategory: String
    ) {
        auth =FirebaseAuth.getInstance()
        val product = AddProductModel(proName,imgUri.toString(),proPrice,proDes)
        db.getReference("Products").child(selectedCategory)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            if(data!!.data != null){
                imgUri = data.data!!
                binding.imgSelectProduct.setImageURI(imgUri)
            }else{
                Toast.makeText(this@AdminActivity,"No",Toast.LENGTH_SHORT).show()
            }

        }

    }
}