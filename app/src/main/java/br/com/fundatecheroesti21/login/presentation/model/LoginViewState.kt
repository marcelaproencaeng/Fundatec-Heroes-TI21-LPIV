package br.com.fundatecheroesti21.login.presentation.model

sealed class LoginViewState {
    object ShowEmailErrorMessage : LoginViewState()
    object ShowPasswordErrorMessage : LoginViewState()
    object ShowErrorMessage : LoginViewState()
    object ShowHomeScreen : LoginViewState()
    object ShowLoading : LoginViewState()
}
