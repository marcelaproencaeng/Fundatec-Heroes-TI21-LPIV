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
    private val useCase by lazy { IsValidCacheUseCase() }
    val splash: LiveData<SplashViewState> = viewState

    init {
        viewModelScope.launch {
            if (useCase.isValidCache()) {
                viewState.value = SplashViewState.ShowHomeScreen
            } else {
                viewState.value = SplashViewState.ShowLoginScreen
            }
        }
    }


}

