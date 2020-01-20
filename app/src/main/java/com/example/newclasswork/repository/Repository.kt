package com.example.newclasswork.repository

import com.example.newclasswork.network.UserListResponse
import retrofit2.Call

interface Repository {

    fun getUserList(): Call<UserListResponse>
}