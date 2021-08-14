package com.getvalue.pinclothes.data.model.getPost

data class GetPostResponse(
    val message: String,
    val result: List<PostItem>,
    val status: Int
)