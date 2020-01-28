package com.example.newclasswork.repository

import com.example.newclasswork.network.UserListResponse
import com.example.newclasswork.network.UserResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteRepository() : Repository {

    init {
        createApi()
    }

    companion object {
        private var repo: RemoteRepository? = null
        fun getInstance(): RemoteRepository {

            if (repo == null) {
                repo = RemoteRepository()
            }
            return repo!!
        }
    }

    private lateinit var api: ApiInterface
    private val token = "pRFu_024dWHjfu5Wl7Wv8vzSoWbslXRAAo0y"
    private val format = "json"

    override fun getUserList(): Call<UserListResponse> = api.getUserList(
        format,
        token
    )

    override fun getUser(id: Int?): Call<UserResponse> = api.getUser(
        id,
        format,
        token
    )
    private fun createApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gorest.co.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiInterface::class.java)
    }
}