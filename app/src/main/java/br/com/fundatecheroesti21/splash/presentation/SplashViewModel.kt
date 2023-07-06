package br.com.fundatecheroesti21.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatecheroesti21.login.domain.LoginUseCase
import br.com.fundatecheroesti21.profile.presentation.model.ProfileViewState

class SplashViewModel : ViewModel() {
    private val useCase by lazy { LoginUseCase() }
    private val viewS = MutableLiveData<ProfileViewState>()
    val splash: LiveData<ProfileViewState> = viewS

    fun init (){

    }
}