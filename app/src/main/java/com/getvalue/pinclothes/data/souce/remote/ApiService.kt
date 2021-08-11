package com.getvalue.pinclothes.data.souce.remote

import com.getvalue.pinclothes.data.model.PersonResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Uwais Alqadri on August 08, 2021
 */
interface ApiService {

	@GET("employee")
	suspend fun getEmployee(
		@Query("noofRecords") nofRecords: Int,
		@Query("idStarts") idStarts: Int
	) : PersonResponse

}