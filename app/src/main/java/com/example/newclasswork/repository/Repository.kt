package com.example.newclasswork.repository

import com.example.newclasswork.network.UserListResponse
import com.example.newclasswork.network.UserResponse
import retrofit2.Call

interface Repository {


    fun getUserList(): Call<UserListResponse>
    fun getUser(id: Int?): Call<UserResponse>
}