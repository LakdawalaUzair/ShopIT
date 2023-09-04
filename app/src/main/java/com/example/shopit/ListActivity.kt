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
//        Toast.makeText(this@ListActivity,"Product  name :  $productName",Toast.LENGTH_SHORT).show()


        if(productName=="Laptop"){
            getLaptopData()
        }

        if(productName=="Charger"){
            getChargerData()
        }

        if(productName=="Desktop Monitor"){
            getMonitorData()
        }

        if(productName=="Desktop"){
            getDesktopData()
        }

        if(productName=="Mouse"){
            getMouseData()
        }

        if(productName=="Keyboard"){
            getKeyboardData()
        }

        if(productName=="Printer"){
            getPrinterData()
        }

        if(productName=="Motherboard"){
            getMotherboardData()
        }

        if(productName=="Anti-Virus"){
            getAntiVirusData()
        }

        if(productName=="Router Switches"){
            getRouterSwitchesData()
        }
    }

    private fun getLaptopData() {

        val productImage = listOf(
            R.drawable.legion_laptop,
            R.drawable.lenovo_laptop,
            R.drawable.slim,
            R.drawable.tuf,
            R.drawable.v15,
            R.drawable.legion_laptop,
            R.drawable.lenovo_laptop,
            R.drawable.slim,
            R.drawable.tuf,
            R.drawable.v15

        )
        val productPrice = listOf(
            "₹ 89,999",
            "₹ 48,350",
            "₹ 39,050",
            "₹ 56,810",
            "₹ 33,099",
            "₹ 89,999",
            "₹ 48,350",
            "₹ 39,050",
            "₹ 56,810",
            "₹ 33,099"
        )

         val productNames = listOf(
            "Lenovo Legion 5",
            "Lenovo Ideapad 3",
            "Lenovo Slim 3",
            "Asus Tuf F15",
            "Lenovo V15",
             "Lenovo Legion 5",
             "Lenovo Ideapad 3",
             "Lenovo Slim 3",
             "Asus Tuf F15",
             "Lenovo V15"
        )
        setRecyclerView(productImage,productNames,productPrice)
    }

    private fun getChargerData() {

        val productImage = listOf(
            R.drawable.asus,
            R.drawable.enter_acer,
            R.drawable.lapkit,
            R.drawable.lappy_power,
            R.drawable.lenovo_regular_pin,
            R.drawable.asus,
            R.drawable.enter_acer,
            R.drawable.lapkit,
            R.drawable.lappy_power,
            R.drawable.lenovo_regular_pin
        )
        val productPrice = listOf(
            "₹ 1,950",
            "₹ 1,199",
            "₹ 1,690",
            "₹ 1,589",
            "₹ 1,870",
            "₹ 1,950",
            "₹ 1,199",
            "₹ 1,690",
            "₹ 1,589",
            "₹ 1,870"
        )

        val productNames = listOf(
            "Asus Adapter",
            "Enter Acer Pin",
            "Lapkit AC",
            "Lappy Power",
            "Lenovo Regular Pin",
            "Asus Adapter",
            "Enter Acer Pin",
            "Lapkit AC",
            "Lappy Power",
            "Lenovo Regular Pin"
        )
        setRecyclerView(productImage,productNames,productPrice)
    }

    private fun getMonitorData() {

        val productImage = listOf(
            R.drawable.two_four,
            R.drawable.twotwo,
            R.drawable.one_nine_five,
            R.drawable.one_eight_five,
            R.drawable.seventeen,
            R.drawable.two_four,
            R.drawable.twotwo,
            R.drawable.one_nine_five,
            R.drawable.one_eight_five,
            R.drawable.seventeen
        )
        val productPrice = listOf(
            "₹ 6,650",
            "₹ 5,999",
            "₹ 4,149",
            "₹ 3,869",
            "₹ 3,450",
            "₹ 6,650",
            "₹ 5,999",
            "₹ 4,149",
            "₹ 3,869",
            "₹ 3,450"
        )

        val productNames = listOf(
            "Geonix 24 inch",
            "HP 22 inch",
            "Geonix 19.5 inch",
            "Geonix 18.5 inch",
            "Geonix 17 inch",
            "Geonix 24 inch",
            "HP 22 inch",
            "Geonix 19.5 inch",
            "Geonix 18.5 inch",
            "Geonix 17 inch"
        )
        setRecyclerView(productImage,productNames,productPrice)
    }

    private fun getDesktopData() {

        val productImage = listOf(
            R.drawable.all_in_one,
            R.drawable.hp,
            R.drawable.legion_pc,
            R.drawable.lenovo,
            R.drawable.all_in_one,
            R.drawable.hp,
            R.drawable.legion_pc,
            R.drawable.lenovo,
            R.drawable.all_in_one,
            R.drawable.hp
        )
        val productPrice = listOf(
            "₹ 64,550",
            "₹ 49,530",
            "₹ 1,20,050",
            "₹ 38,490",
            "₹ 64,550",
            "₹ 49,530",
            "₹ 1,20,050",
            "₹ 38,490",
            "₹ 64,550",
            "₹ 49,530"
        )

        val productNames = listOf(
            "Lenovo IdeaCenter AIO 3",
            "HP",
            "Lenovo Legion Tower 5",
            "Lenovo IdeaCenter 3",
            "Lenovo IdeaCenter AIO 3",
            "HP",
            "Lenovo Legion Tower 5",
            "Lenovo IdeaCenter 3",
            "Lenovo IdeaCenter AIO 3",
            "HP"
        )
        setRecyclerView(productImage,productNames,productPrice)
    }

    private fun getMouseData() {

        val productImage = listOf(
            R.drawable.ambrane_rgb,
            R.drawable.ant_esports,
            R.drawable.lenovo_300,
            R.drawable.lenovo_m100_rgb,
            R.drawable.logitech,
            R.drawable.ambrane_rgb,
            R.drawable.ant_esports,
            R.drawable.lenovo_300,
            R.drawable.lenovo_m100_rgb,
            R.drawable.logitech
        )
        val productPrice = listOf(
            "₹ 450",
            "₹ 590",
            "₹ 330",
            "₹ 640",
            "₹ 395",
            "₹ 450",
            "₹ 590",
            "₹ 330",
            "₹ 640",
            "₹ 395"
        )

        val productNames = listOf(
            "Ambrane Trone RGB",
            "Ant Esports GM60",
            "Lenovo 300",
            "Lenovo M100 RGB",
            "Logitech M90",
            "Ambrane Trone RGB",
            "Ant Esports GM60",
            "Lenovo 300",
            "Lenovo M100 RGB",
            "Logitech M90"
        )
        setRecyclerView(productImage,productNames,productPrice)
    }

    private fun getKeyboardData() {

        val productImage = listOf(
            R.drawable.blazing,
            R.drawable.dell,
            R.drawable.fingers,
            R.drawable.lapcare,
            R.drawable.zebronics_zeb,
            R.drawable.blazing,
            R.drawable.dell,
            R.drawable.fingers,
            R.drawable.lapcare,
            R.drawable.zebronics_zeb
        )
        val productPrice = listOf(
            "₹ 699",
            "₹ 1,370",
            "₹ 900",
            "₹ 400",
            "₹ 950",
            "₹ 699",
            "₹ 1,370",
            "₹ 900",
            "₹ 400",
            "₹ 950"
        )

        val productNames = listOf(
            "Fingers Blazing BlueLit",
            "Dell KM3322W",
            "Fingers Magnifico Moonlit",
            "Lapcare Alfa 1",
            "Zebronics Zeb Tra-k",
            "Fingers Blazing BlueLit",
            "Dell KM3322W",
            "Fingers Magnifico Moonlit",
            "Lapcare Alfa 1",
            "Zebronics Zeb Tra-k"
        )
        setRecyclerView(productImage,productNames,productPrice)
    }

    private fun getPrinterData() {

        val productImage = listOf(
            R.drawable.brother,
            R.drawable.epson,
            R.drawable.hp_printer,
            R.drawable.pantum,
            R.drawable.brother,
            R.drawable.epson,
            R.drawable.hp_printer,
            R.drawable.pantum,
            R.drawable.brother,
            R.drawable.epson
        )
        val productPrice = listOf(
            "₹ 11,600",
            "₹ 15,250",
            "₹ 12,999",
            "₹ 9,700",
            "₹ 1,870",
            "₹ 11,600",
            "₹ 15,250",
            "₹ 12,999",
            "₹ 9,700",
            "₹ 1,870",
            "₹ 11,600",
            "₹ 15,250",
            "₹ 12,999"
        )

        val productNames = listOf(
            "Brother HL-L2321D",
            "Epson L3250 Multi-fanction",
            "HP Laserjet 108w",
            "Pantum P2518",
            "Brother HL-L2321D",
            "Epson L3250 Multi-fanction",
            "HP Laserjet 108w",
            "Pantum P2518",
            "Brother HL-L2321D",
            "Epson L3250 Multi-fanction"
        )
        setRecyclerView(productImage,productNames,productPrice)
    }

    private fun getMotherboardData() {

        val productImage = listOf(
            R.drawable.geforce,
            R.drawable.gigabyte,
            R.drawable.mercury,
            R.drawable.geforce,
            R.drawable.gigabyte,
            R.drawable.mercury,
            R.drawable.geforce,
            R.drawable.gigabyte,
            R.drawable.mercury,
            R.drawable.geforce
        )
        val productPrice = listOf(
            "₹ 2,069",
            "₹ 6,300",
            "₹ 3,759",
            "₹ 2,069",
            "₹ 6,300",
            "₹ 3,759",
            "₹ 2,069",
            "₹ 6,300",
            "₹ 3,759",
            "₹ 2,069"
        )

        val productNames = listOf(
            "Geforce GT-610LP",
            "GigaByte H410M S2 V2",
            "Mercury Nvidia GT710",
            "Geforce GT-610LP",
            "GigaByte H410M S2 V2",
            "Mercury Nvidia GT710",
            "Geforce GT-610LP",
            "GigaByte H410M S2 V2",
            "Mercury Nvidia GT710",
            "Geforce GT-610LP"
        )
        setRecyclerView(productImage,productNames,productPrice)
    }

    private fun getAntiVirusData() {

        val productImage = listOf(
            R.drawable.quick_heal,
            R.drawable.vibranium,
            R.drawable.quick_heal,
            R.drawable.vibranium,
            R.drawable.quick_heal,
            R.drawable.vibranium,
            R.drawable.quick_heal,
            R.drawable.vibranium,
            R.drawable.quick_heal,
            R.drawable.vibranium
        )
        val productPrice = listOf(
            "₹ 850",
            "₹ 499",
            "₹ 850",
            "₹ 499",
            "₹ 850",
            "₹ 499",
            "₹ 850",
            "₹ 499",
            "₹ 850",
            "₹ 499"
        )

        val productNames = listOf(
            "Quick Heal",
            "Vibranium",
            "Quick Heal",
            "Vibranium",
            "Quick Heal",
            "Vibranium",
            "Quick Heal",
            "Vibranium",
            "Quick Heal",
            "Vibranium"
        )
        setRecyclerView(productImage,productNames,productPrice)
    }

    private fun getRouterSwitchesData() {

        val productImage = listOf(
            R.drawable.dir_615,
            R.drawable.dir_825,
            R.drawable.geonix,
            R.drawable.jinco,
            R.drawable.dir_615,
            R.drawable.dir_825,
            R.drawable.geonix,
            R.drawable.jinco,
            R.drawable.dir_615,
            R.drawable.dir_825
        )
        val productPrice = listOf(
            "₹ 1,400",
            "₹ 2,100",
            "₹ 450",
            "₹ 350",
            "₹ 1,400",
            "₹ 2,100",
            "₹ 450",
            "₹ 350",
            "₹ 1,400",
            "₹ 2,100"
        )

        val productNames = listOf(
            "D-Link DIR-615",
            "D-Link DIR-825",
            "Geonix GX-150",
            "Jinco N-600",
            "D-Link DIR-615",
            "D-Link DIR-825",
            "Geonix GX-150",
            "Jinco N-600",
            "D-Link DIR-615",
            "D-Link DIR-825"
        )
        setRecyclerView(productImage,productNames,productPrice)
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