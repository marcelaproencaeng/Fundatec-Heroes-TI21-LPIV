package br.com.fundatecheroesti21.profile.presentation.model

sealed class ProfileViewState {
    object ShowNameErrorMessage : ProfileViewState()
    object ShowEmailErrorMessage : ProfileViewState()
    object ShowPasswordErrorMessage : ProfileViewState()
    object ShowErrorMessage : ProfileViewState()
    object ShowHomeScreen : ProfileViewState()
    object ShowLoading : ProfileViewState()
}