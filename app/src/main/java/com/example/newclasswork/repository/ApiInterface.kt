package com.example.newclasswork.repository

import com.example.newclasswork.network.UserListResponse
import com.example.newclasswork.network.UserResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {


    @GET("public-api/users")
    fun getUserList(
        @Query("_format") format: String,
        @Query("access-token") accessToken: String
    ): Call<UserListResponse>

    @GET ("public-api/users/{userId}")
    fun getUser(
        @Path("userId") Id: Int?,
        @Query("_format") format: String,
        @Query("access-token") accessToken: String
    ): Call<UserResponse>


}


