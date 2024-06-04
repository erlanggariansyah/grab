package com.erlanggariansyah.grab.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.erlanggariansyah.grab.R
import com.erlanggariansyah.grab.constant.ExtraConstant
import com.erlanggariansyah.grab.databinding.ActivityInputOtpactivityBinding
import java.util.concurrent.TimeUnit

class InputOTPActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputOtpactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputOtpactivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            val phone: String = intent.getStringExtra(ExtraConstant.PHONE)!!
            val source: String = intent.getStringExtra(ExtraConstant.SOURCE)!!

            backButton.setOnClickListener { toPreviousActivity() }
            input.addTextChangedListener {
                if (it?.length!! > 5) {
                    if (source == "REGISTER") {
                        toInputNameActivity()
                    } else {
                        toMainAuthenticatedActivity()
                    }
                }
            }

            val titleText: String = getString(R.string.otp_title)
            title.text = String.format(titleText, phone)

            val descriptionHintText: String = getString(R.string.otp_desc_hint)
            object: CountDownTimer(30000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    descriptionHint.text = String.format(descriptionHintText, String.format(
                        "%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))
                    ))
                }

                override fun onFinish() {
                    descriptionHint.text = String.format(descriptionHintText, "sini")
                }
            }.start()
        }
    }

    private fun toPreviousActivity() {
        finish()
    }

    private fun toInputNameActivity() {
        startActivity(Intent(this@InputOTPActivity, InputNameActivity::class.java))
    }

    private fun toMainAuthenticatedActivity() {
        startActivity(Intent(this@InputOTPActivity, MainAuthenticatedActivity::class.java))
        finish()
    }
}
