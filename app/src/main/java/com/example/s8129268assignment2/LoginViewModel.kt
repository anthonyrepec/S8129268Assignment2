package com.example.s8129268assignment2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AnimalsRepository) : ViewModel() {
    private val _result = MutableSharedFlow<LoginResult>()
    val result = _result.asSharedFlow()

    //Login Function
    fun login(username: String, password: String) {
        viewModelScope.launch {
            val response = repository.submitLoginDetails(LoginRequest(username, password))
            val keypass = response.body()?.keypass

            if (response.isSuccessful && keypass != null) {
                _result.emit(LoginResult.Success(keypass))
            }
            else {
                _result.emit(LoginResult.Failed)
            }
        }
    }
}

sealed class LoginResult {
    data class Success(val keypass: String) : LoginResult()
    data object Failed : LoginResult()

}