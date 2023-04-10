package com.example.msg_assignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.msg_assignment.model.api.GithubApi
import com.example.msg_assignment.model.data.User
import kotlinx.coroutines.launch


class ResultViewModel : ViewModel(){

    private val _userInfo = MutableLiveData<User>()

    val userInfo: LiveData<User>
        get() = _userInfo

    fun searchUser(userName: String){
        viewModelScope.launch {
            kotlin.runCatching {
                GithubApi.searchUser(userName)
            }.onSuccess {
                if (it.body() != null) {
                    _userInfo.value = it.body()
                }
            }.onFailure {
            }
        }
    }

}