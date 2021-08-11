package com.getvalue.pinclothes.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.getvalue.pinclothes.data.model.PersonItem
import com.getvalue.pinclothes.data.repository.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
	private val repository: PersonRepository
): ViewModel() {

	private val _personData = MutableLiveData<List<PersonItem>>()
	val personData = _personData
	val loading = MutableLiveData<Boolean>()

	init {
		fetchEmployee()
	}

	private fun fetchEmployee() = viewModelScope.launch {
		loading.value = true
		repository.fetchEmployee(10, 1001).collect { persons ->
			_personData.value = persons
			loading.value = false
		}
	}
}