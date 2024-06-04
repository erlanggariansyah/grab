package com.erlanggariansyah.grab.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erlanggariansyah.grab.constant.ExtraConstant
import com.erlanggariansyah.grab.databinding.ActivityInputPhoneBinding

class InputPhoneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputPhoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputPhoneBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            val source: String = intent.getStringExtra(ExtraConstant.SOURCE)!!

            backButton.setOnClickListener { toPreviousActivity() }
            inputButton.setOnClickListener {
                toInputOTPActivity("+" + countryCodePicker.selectedCountryCode + input.text, source)
            }
        }
    }

    private fun toPreviousActivity() {
        finish()
    }

    private fun toInputOTPActivity(phone: String, source: String) {
        val intent = Intent(this@InputPhoneActivity, InputOTPActivity::class.java)
        intent.putExtra(ExtraConstant.PHONE, phone)
        intent.putExtra(ExtraConstant.SOURCE, source)

        startActivity(intent)
    }
}
