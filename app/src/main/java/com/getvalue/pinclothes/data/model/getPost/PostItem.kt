package com.getvalue.pinclothes.data.model.getPost

data class PostItem(
    val caption: String,
    val created_at: String,
    val id: Int,
    val img_path: String,
    val updated_at: String,
    // val upvotes: List<Any>,
    val user_id: Int
)