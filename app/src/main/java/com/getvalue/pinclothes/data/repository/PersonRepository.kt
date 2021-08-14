package com.getvalue.pinclothes.data.repository

import com.getvalue.pinclothes.data.model.PersonItem
import com.getvalue.pinclothes.data.model.PersonResponse
import com.getvalue.pinclothes.data.souce.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber

class PersonRepository(
	private val apiService: ApiService
) {

	suspend fun fetchEmployee(nofRecords: Int, idStarts: Int): Flow<List<PersonItem>> {
		return flow {
			val response = apiService.getEmployee(nofRecords, idStarts)
			try {
				if (response.isNotEmpty()) {
					emit(response)
				} else {
					Timber.d("empty")
				}
			} catch (e: HttpException) {
				Timber.d("error ${e.message()}")
			}
		}
	}

}