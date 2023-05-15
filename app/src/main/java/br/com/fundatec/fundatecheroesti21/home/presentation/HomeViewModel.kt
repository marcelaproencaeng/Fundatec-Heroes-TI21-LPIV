package br.com.fundatec.fundatecheroesti21.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroesti21.home.presentation.model.HomeViewState
import br.com.fundatec.fundatecheroesti21.profile.presentation.model.ProfileViewState


class HomeViewModel : ViewModel(){

    private val viewS = MutableLiveData<HomeViewState>()
    val s: LiveData<HomeViewState> = viewS

    fun validateInputs(name: String?, description: String?, age: String?,date: String?) {
        viewS.value = HomeViewState.ShowLoading
        if (name.isNullOrBlank() && description.isNullOrBlank() && age.isNullOrBlank() && date.isNullOrBlank()) {
            viewS.value = HomeViewState.ShowErrorMessage
            return
        }
        if (name.isNullOrBlank()) {
            viewS.value = HomeViewState.ShowNameErrorMessage
            return
        }
        if(description.isNullOrBlank()){
            viewS.value =HomeViewState.ShowDescriptionErrorMessage
            return
        }
        if(age.isNullOrBlank()){
            viewS.value =HomeViewState.ShowAgeErrorMessage
            return
        }
        if (date.isNullOrBlank()){
            viewS.value= HomeViewState.ShowDateErrorMessage
            return
        }
}