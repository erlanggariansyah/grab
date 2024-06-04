package com.erlanggariansyah.grab.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erlanggariansyah.grab.constant.ExtraConstant
import com.erlanggariansyah.grab.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            backButton.setOnClickListener { toPreviousActivity() }
            loginByPhoneButton.setOnClickListener { toInputPhoneActivity("LOGIN") }
        }
    }

    private fun toPreviousActivity() {
        finish()
    }

    private fun toInputPhoneActivity(source: String) {
        val intent  = Intent(this@LoginActivity, InputPhoneActivity::class.java)
        intent.putExtra(ExtraConstant.SOURCE, source)

        startActivity(intent)
    }
}
