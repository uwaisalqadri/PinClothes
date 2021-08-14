package com.getvalue.pinclothes.data.repository

import com.getvalue.pinclothes.data.model.PersonItem
import com.getvalue.pinclothes.data.model.login.ResponseLogin
import com.getvalue.pinclothes.data.souce.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber

class AuthRepository(
    private val apiService: ApiService
) {

    suspend fun fetchLogin(username: String, password: String): Flow<ResponseLogin> {
        return flow {
            val response = apiService.login(username, password)

            try {
                if (response != null) {
                    emit(response)
                } else {
                    Timber.d("empty")
                }
            }catch (e: HttpException){
                Timber.d("error ${e.message()}")

            }

        }
    }

}