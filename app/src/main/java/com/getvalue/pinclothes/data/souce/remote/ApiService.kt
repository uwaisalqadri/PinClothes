package com.getvalue.pinclothes.data.souce.remote

import com.getvalue.pinclothes.data.model.PersonResponse
import com.getvalue.pinclothes.data.model.login.ResponseLogin
import retrofit2.http.*

/**
 * Created by Uwais Alqadri on August 08, 2021
 */
interface ApiService {

    @GET("employee")
    suspend fun getEmployee(
        @Query("noofRecords") nofRecords: Int,
        @Query("idStarts") idStarts: Int
    ): PersonResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): ResponseLogin


}