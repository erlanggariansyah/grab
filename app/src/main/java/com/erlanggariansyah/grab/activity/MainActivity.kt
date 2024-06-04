package com.erlanggariansyah.grab.activity

import android.content.Intent
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.erlanggariansyah.grab.R
import com.erlanggariansyah.grab.adapter.HorizontalFoodAdapter
import com.erlanggariansyah.grab.adapter.HorizontalMenuAdapter
import com.erlanggariansyah.grab.constant.ExtraConstant
import com.erlanggariansyah.grab.databinding.ActivityMainBinding
import com.erlanggariansyah.grab.dto.HorizontalMenuItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            with(binding) {
                val source = ImageDecoder.createSource(resources, R.drawable.main_welcoming_vector_animated)
                val drawable = ImageDecoder.decodeDrawable(source)

                imageHeaderBackgroundVector.setImageDrawable(drawable)
                (drawable as? AnimatedImageDrawable)?.start()
            }
        }

        showHorizontalMenu()
        showHorizontalFood()
        showHorizontalMart()

        with(binding) {
            layoutRegisterPrize.setOnClickListener { showAlertLogin() }
            loginButton.setOnClickListener { toLoginActivity() }
            loginAlertButton.setOnClickListener { toLoginActivity() }
            registerButton.setOnClickListener { toInputPhoneActivity("REGISTER") }
            registerAlertButton.setOnClickListener { toInputPhoneActivity("REGISTER") }
        }
    }

    private fun toLoginActivity() {
        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
    }

    private fun toInputPhoneActivity(source: String) {
        val intent = Intent(this@MainActivity, InputPhoneActivity::class.java)
        intent.putExtra(ExtraConstant.SOURCE, source)

        startActivity(intent)
    }

    private fun showHorizontalMenu() {
        with(binding) {
            val menus: ArrayList<HorizontalMenuItem> = ArrayList()
            menus.add(HorizontalMenuItem(R.drawable.icon_food, "Makanan"))
            menus.add(HorizontalMenuItem(R.drawable.icon_mart, "Mart"))
            menus.add(HorizontalMenuItem(R.drawable.icon_car, "Mobil"))
            menus.add(HorizontalMenuItem(R.drawable.icon_motocycle, "Motor"))
            menus.add(HorizontalMenuItem(R.drawable.icon_express, "Express"))

            recyclerHorizontalMenu.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            recyclerHorizontalMenu.adapter = HorizontalMenuAdapter(menus)
        }
    }

    private fun showHorizontalFood() {
        with(binding) {
            val menus: ArrayList<HorizontalMenuItem> = ArrayList()
            menus.add(HorizontalMenuItem(R.drawable.icon_increase, "Terlaris"))
            menus.add(HorizontalMenuItem(R.drawable.icon_food_2, "Kuliner Lokal"))
            menus.add(HorizontalMenuItem(R.drawable.icon_location, "Terdekat"))
            menus.add(HorizontalMenuItem(R.drawable.icon_food_3, "Semua Makanan"))

            recyclerHorizontalFood.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            recyclerHorizontalFood.adapter = HorizontalFoodAdapter(menus)
        }
    }

    private fun showHorizontalMart() {
        with(binding) {
            val menus: ArrayList<HorizontalMenuItem> = ArrayList()
            menus.add(HorizontalMenuItem(R.drawable.icon_vegetables, "Produk Segar"))
            menus.add(HorizontalMenuItem(R.drawable.icon_meats, "Daging & Seafood"))
            menus.add(HorizontalMenuItem(R.drawable.icon_search, "Telusuri Mart"))

            recyclerHorizontalMart.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            recyclerHorizontalMart.adapter = HorizontalFoodAdapter(menus)
        }
    }

    private fun showAlertLogin() {
        with(binding) {
            if (alertLogin.visibility == View.INVISIBLE) {
                alertLogin.visibility = View.VISIBLE
            } else {
                alertLogin.visibility = View.INVISIBLE
            }
        }
    }
}
