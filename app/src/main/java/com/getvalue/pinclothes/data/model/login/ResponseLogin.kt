package com.getvalue.pinclothes.data.model.login

data class ResponseLogin(
    val result: LoginItem,
    val status: String,
    val token: String
)