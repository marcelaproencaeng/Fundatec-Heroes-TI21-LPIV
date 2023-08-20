package br.com.fundatecheroesti21.home.presentation.model

sealed class HomeViewState {
    data class ShowHome(val list: List<CharacterModel>) : HomeViewState()
    object ShowError : HomeViewState()
    object ShowLoading : HomeViewState()
    object ShowEmptyList : HomeViewState()

}

