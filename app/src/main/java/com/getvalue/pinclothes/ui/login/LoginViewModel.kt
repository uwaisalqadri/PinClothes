package com.getvalue.pinclothes.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.getvalue.pinclothes.data.model.login.ResponseLogin
import com.getvalue.pinclothes.data.repository.AuthRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AuthRepository
): ViewModel() {

    private val _loginData = MutableLiveData<ResponseLogin>()
    val loginData = _loginData
    val loading = MutableLiveData<Boolean>()


    fun login(email: String, password: String) = viewModelScope.launch {
        loading.value = true
        repository.fetchLogin(email, password).collect{ login ->
            _loginData.value = login
            loading.value = false

        }
    }

}