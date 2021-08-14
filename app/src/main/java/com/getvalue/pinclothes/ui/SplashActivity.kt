package com.getvalue.pinclothes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.getvalue.pinclothes.R
import com.getvalue.pinclothes.ui.login.LoginActivity
import com.getvalue.pinclothes.ui.sample.MainActivity

class SplashActivity : AppCompatActivity() {

	private val handler = Handler(Looper.getMainLooper())
	private var isLogged = false

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash)
		supportActionBar?.hide()

		handler.postDelayed({
			if (isLogged) {
				startActivity(Intent(this, MainActivity::class.java))
			} else {
				startActivity(Intent(this, LoginActivity::class.java))
			}
		}, 2000)
	}
}