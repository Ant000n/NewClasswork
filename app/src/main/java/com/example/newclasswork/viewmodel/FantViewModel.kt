package com.example.newclasswork.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newclasswork.network.UserResponse
import com.example.newclasswork.repository.RemoteRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FantViewModel : ViewModel() {

    private val repository = RemoteRepository.getInstance()

    val userListLiveData = MutableLiveData<UserResponse>()
    fun getUser(id: Int?) {
        repository.getUser(id)
            .enqueue(object : Callback<UserResponse> {
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    userListLiveData.postValue(response.body())
                }
            })
    }
}
