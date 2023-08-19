package br.com.fundatecheroesti21.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatecheroesti21.splash.domain.IsValidCacheUseCase
import br.com.fundatecheroesti21.splash.presentation.model.SplashViewState
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    //Tela de splash deve consultar no banco de dados se já existe um usuário
// se existir e o tempo do ultimo login for maior que 10(1) minutos devemos
// levar o usuário para a tela de login,
// caso não exista o usuário no banco de dados
// devemos levar o usuário direto para tela de login

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

