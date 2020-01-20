package com.example.newclasswork.network

data class UserListResponse(
    val result: List<ResultItem>? = null,
    val meta: Meta? = null
)