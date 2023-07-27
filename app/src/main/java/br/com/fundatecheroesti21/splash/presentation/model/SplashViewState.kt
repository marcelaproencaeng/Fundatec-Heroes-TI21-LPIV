package br.com.fundatecheroesti21.splash.presentation.model


sealed class SplashViewState {

    object ShowLoginScreen : SplashViewState()
    object ShowHomeScreen : SplashViewState()

}