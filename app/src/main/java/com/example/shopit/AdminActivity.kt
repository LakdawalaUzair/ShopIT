package com.example.shopit

import android.R
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shopit.admin.AddProductModel
import com.example.shopit.databinding.ActivityAdminBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlin.random.Random

class AdminActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdminBinding
    private lateinit var imgUri: Uri
    private var auth = FirebaseAuth.getInstance()
    private lateinit var db: FirebaseDatabase
    private lateinit var selectedCategory: String

    val categories = arrayOf(
        "Laptop",
        "Charger",
        "Desktop Monitor",
        "Desktop",
        "Mouse",
        "Keyboard",
        "Printer",
        "Motherboard",
        "Anti-Virus",
        "Router Switches"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgSelectProduct.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 100)
        }

        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.proCategory.adapter = adapter

        binding.proCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedCategory = categories[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case where nothing is selected
            }
        }
        binding.proCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedCategory = categories[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case where nothing is selected
            }
        }

        db = FirebaseDatabase.getInstance() // Initialize the database

        binding.btnAddProduct.setOnClickListener {
            val proName = binding.etProductName.text.toString()
            val proPrice = binding.etProductPrice.text.toString()
            val proDes = binding.etDesProdct.text.toString()

            if (proName.isNotEmpty() && proPrice.isNotEmpty() && proDes.isNotEmpty() && imgUri != null) {
                saveData2Database(proName, proPrice, proDes, imgUri, selectedCategory)
            } else {
                Toast.makeText(this@AdminActivity, "Please enter all details", Toast.LENGTH_SHORT).show()
            }
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (data!!.data != null) {
                imgUri = data.data!!
                binding.imgSelectProduct.setImageURI(imgUri)
            } else {
                Toast.makeText(this@AdminActivity, "No image selected", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun saveData2Database(
        proName: String,
        proPrice: String,
        proDes: String,
        imgUri: Uri,
        selectedCategory: String
    ){
        val auth = FirebaseAuth.getInstance()
        val randomNumber = Random.nextInt(1000) + 1 // Generate a random number between 1 and 1000
        val storage = FirebaseStorage.getInstance().reference
        val productsRef = storage.child("Products").child(selectedCategory).child(randomNumber.toString())

        productsRef.putFile(imgUri)
            .addOnSuccessListener { uploadTask ->
                // Get the download URL for the uploaded image
                productsRef.downloadUrl.addOnSuccessListener { uri ->
                    val product = AddProductModel(proName, uri.toString(), proPrice, proDes)
                    val databaseRef = FirebaseDatabase.getInstance().getReference("Products").child(selectedCategory).child(randomNumber.toString())

                    databaseRef.setValue(product)
                        .addOnSuccessListener {
                            Toast.makeText(this@AdminActivity, "Product Added Successfully", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { exception ->
                            Toast.makeText(this@AdminActivity, "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            .addOnFailureListener {

            }


    }
}
