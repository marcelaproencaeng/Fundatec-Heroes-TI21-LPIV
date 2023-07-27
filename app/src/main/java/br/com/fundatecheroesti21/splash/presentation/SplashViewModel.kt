package br.com.fundatecheroesti21.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatecheroesti21.splash.domain.IsValidCacheUseCase
import br.com.fundatecheroesti21.splash.presentation.model.SplashViewState
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val viewState = MutableLiveData<SplashViewState>()
    val splash: LiveData<SplashViewState> = viewState

    private val useCase by lazy { IsValidCacheUseCase() }

    init {
        viewModelScope.launch {
            if (useCase.isValidCache()) {
                viewState.value = SplashViewState.ShowHomeScreen
            } else {
                viewState.value = SplashViewState.ShowLoginScreen
            }
        }
    }
//    private val useCase by lazy { LoginUseCase() }
//    private val viewS = MutableLiveData<SplashViewState>()
//    val splash: LiveData<SplashViewState> = viewS

//    fun validateCache() {
//        viewModelScope.launch {
//            viewS.value = SplashViewState.ShowLoginScreen
//            val userExist: Boolean = true
//            useCase.isUserExist(userExist)
//            if (!userExist) {
//                viewS.value = SplashViewState.ShowLoginScreen
//            }
//
//            val isTimeMaior: Boolean = true
//            useCase.validateLogin(isTimeMaior)
//            if (!isTimeMaior) {
//                viewS.value = SplashViewState.ShowLoginScreen
//            }
//
//        }
//
//
//    }


}

