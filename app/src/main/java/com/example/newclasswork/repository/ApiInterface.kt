package com.example.newclasswork.repository

import com.example.newclasswork.network.UserListResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {


    @GET("public-api/users")
    fun getUserList(
        @Query("_format") format: String,
        @Query("access-token") accessToken: String
    ): Call<UserListResponse>


}


