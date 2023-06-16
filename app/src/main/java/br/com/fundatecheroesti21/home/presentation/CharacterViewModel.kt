package br.com.fundatecheroesti21.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatecheroesti21.home.presentation.model.CharacterViewState

class CharacterViewModel : ViewModel() {

    private val viewS = MutableLiveData<CharacterViewState>()
    val s: LiveData<CharacterViewState> = viewS

    fun validateInputs(
        name: String?,
        description: String?,
        age: String?,
        date: String?,
        url: String?
    ) {
        viewS.value = CharacterViewState.ShowLoading
        if (name.isNullOrBlank() && description.isNullOrBlank() && age.isNullOrBlank() && date.isNullOrBlank() && url.isNullOrBlank()) {
            viewS.value = CharacterViewState.ShowErrorMessage
            return
        }
        if (name.isNullOrBlank()) {
            viewS.value = CharacterViewState.ShowNameErrorMessage
            return
        }
        if (description.isNullOrBlank()) {
            viewS.value = CharacterViewState.ShowDescriptionErrorMessage
            return
        }
        if (age.isNullOrBlank()) {
            viewS.value = CharacterViewState.ShowAgeErrorMessage
            return
        }
        if (date.isNullOrBlank()) {
            viewS.value = CharacterViewState.ShowDateErrorMessage
            return
        }
        if (url.isNullOrBlank()) {
            viewS.value = CharacterViewState.ShowUrlErrorMessage
            return
        }
    }
}


