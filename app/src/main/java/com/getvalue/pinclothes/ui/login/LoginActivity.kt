package com.getvalue.pinclothes.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.getvalue.pinclothes.R
import com.getvalue.pinclothes.databinding.ActivityLoginBinding
import com.getvalue.pinclothes.utils.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by viewBinding()
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        binding.apply {
            btnLogin.setOnClickListener {
                val email = edtEmail.text.toString()
                val password = edtPassword.text.toString()
                viewModel.login(email, password)
            }

            viewModel.apply {
                loading.observe(this@LoginActivity) {
                    pgLogin.isVisible = it
                    btnLogin.text = if (it) "Login" else ""
                }

                loginData.observe(this@LoginActivity) {
                    showToast("Login Success")
                }
            }
        }
    }
}








