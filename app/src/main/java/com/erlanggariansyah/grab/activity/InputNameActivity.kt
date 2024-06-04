package com.erlanggariansyah.grab.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erlanggariansyah.grab.databinding.ActivityInputNameBinding

class InputNameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputNameBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            backButton.setOnClickListener { toPreviousActivity() }
            inputButton.setOnClickListener { toMainAuthenticatedActivity() }
        }
    }

    private fun toPreviousActivity() {
        finish()
    }

    private fun toMainAuthenticatedActivity() {
        startActivity(Intent(this@InputNameActivity, MainAuthenticatedActivity::class.java))
        finish()
    }
}
