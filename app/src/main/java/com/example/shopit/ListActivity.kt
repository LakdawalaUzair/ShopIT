package com.example.shopit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopit.databinding.ActivityListBinding
import java.lang.Exception

class ListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val productName = intent.getStringExtra("name")
        Toast.makeText(this@ListActivity,"Product  name :  $productName",Toast.LENGTH_SHORT).show()


        if(productName=="Laptop"){
            getLaptopData()
        }



//        when(productName){
//            "laptop"->{
//                getLaptopData()
//            }
//
//            "charger"->{
//                getCharger()
//            }
//            "desktop monitor"->{
//
//            }
//            "desktop"->{
//
//            }
//            "mouse"->{
//
//            }
//            "keyboard"->{
//
//            }
//            "printer"->{
//
//            }
//            "motherboard"->{
//
//            }
//            "anti-virus"->{
//
//            }
//            "router switches"->{
//
//            }
//
//
//
//        }


    }

    private fun getLaptopData() {

        val productImage = listOf(
            R.drawable.legion_laptop,
            R.drawable.lenovo,
            R.drawable.slim,
            R.drawable.tuf,
            R.drawable.v15
        )
        val productPrice = listOf(
            "₹ 57000",
            "₹ 46000",
            "₹ 15500",
            "₹ 39000",
            "₹ 68900"
        )

         val productNames = listOf(
            "Legion laptop",
            "Lenovo",
            "Slim",
            "Tuf",
            "V15"
        )
        setRecyclerView(productImage,productNames,productPrice)
    }

    private fun getCharger() {

        var images = listOf<Int>(
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

        var productNames = listOf<String>(
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
    }



    private fun setRecyclerView(
        productImage: List<Int>,
        productNames: List<String>,
        productPrice: List<String>
    ) {
        binding.listRecyclerView.layoutManager = LinearLayoutManager(this@ListActivity)
        binding.listRecyclerView.adapter =  ListAdapter(this@ListActivity, productImage, productNames, productPrice)

    }
}