package com.example.newclasswork.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newclasswork.fragment.BlanFragment
import com.example.newclasswork.network.UserListResponse
import com.example.newclasswork.repository.RemoteRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlanViewModel : ViewModel() {

    private val repository = RemoteRepository.getInstance()

    val userListLiveData = MutableLiveData<UserListResponse>()

    fun getUserList() {
        repository.getUserList()
            .enqueue(object : Callback<UserListResponse> {
                override fun onFailure(call: Call<UserListResponse>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<UserListResponse>,
                    response: Response<UserListResponse>
                ) {
                    userListLiveData.postValue(response.body())
                }
            })
    }
}
