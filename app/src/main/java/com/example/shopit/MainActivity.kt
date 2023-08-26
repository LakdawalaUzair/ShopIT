package com.example.shopit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var images = listOf<Int>(
        R.drawable.laptop,
        R.drawable.charger,
        R.drawable.desktop_monitor,
        R.drawable.desktop,
        R.drawable.mouse,
        R.drawable.keyboard,
        R.drawable.printer,
        R.drawable.motherboard,
        R.drawable.antivirus,
        R.drawable.router_switches
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