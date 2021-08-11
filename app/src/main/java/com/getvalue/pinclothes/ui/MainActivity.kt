package com.getvalue.pinclothes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.getvalue.pinclothes.R
import com.getvalue.pinclothes.databinding.ActivityMainBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

	private val binding: ActivityMainBinding by viewBinding()
	private val viewModel: MainViewModel by viewModel()
	private val personAdapter = GroupAdapter<GroupieViewHolder>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		with(binding.rvPerson) {
			layoutManager = LinearLayoutManager(this@MainActivity)
			adapter = personAdapter
			setHasFixedSize(true)
		}

		with(viewModel) {
			personData.observe(this@MainActivity) { response ->
				response.map { person ->
					personAdapter.add(PersonItem(person) {
						Timber.d("click $it")
					})
				}
			}

			loading.observe(this@MainActivity) {
				Timber.d("loading $it")
			}
		}
	}
}