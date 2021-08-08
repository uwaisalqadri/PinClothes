package com.getvalue.pinclothes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.getvalue.pinclothes.R
import com.getvalue.pinclothes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private val binding: ActivityMainBinding by viewBinding()
	private val viewModel: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}
}