package com.example.shopit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var images = listOf<Int>(
        R.drawable.demo1,
        R.drawable.demo2,
        R.drawable.demo3,
        R.drawable.demo4,
        R.drawable.demo5,
        R.drawable.demo6,
        R.drawable.demo7,
        R.drawable.demo8,
        R.drawable.demo9,
        R.drawable.demo10
    )

    private var productNames = listOf<String>(
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productList: List<ProductModel> = createProductList()

        binding.mainRecyclerView.adapter = ProductAdapter(this@MainActivity, productList)
        binding.mainRecyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
    }

    private fun createProductList(): List<ProductModel> {
        val productList = mutableListOf<ProductModel>()

        for (i in productNames.indices) {
            productList.add(ProductModel(productNames[i], images[i], "", ""))
        }

        return productList
    }

    override fun onBackPressed() {
        finishAffinity()
        super.onBackPressed()
    }
}