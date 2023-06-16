package br.com.fundatecheroesti21.home.presentation.model

sealed class CharacterViewState {
    object ShowLoginScreen : CharacterViewState()
    object ShowErrorMessage : CharacterViewState()
    object ShowNameErrorMessage : CharacterViewState()
    object ShowDescriptionErrorMessage : CharacterViewState()
    object ShowAgeErrorMessage : CharacterViewState()
    object ShowDateErrorMessage : CharacterViewState()
    object ShowLoading : CharacterViewState()
    object ShowUrlErrorMessage : CharacterViewState()

}

