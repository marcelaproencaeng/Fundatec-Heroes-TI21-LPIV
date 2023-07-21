package br.com.fundatecheroesti21.splash.view


sealed class SplashViewState {

    object ShowLoginScreen : SplashViewState()
    object ShowHomeScreen : SplashViewState()

}