package br.com.fundatecheroesti21.profile.presentation

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatecheroesti21.login.view.LoginActivity

import br.com.fundatecheroesti21.profile.presentation.model.ProfileViewState

class ProfileViewModel : ViewModel() {
    private val viewS = MutableLiveData<ProfileViewState>()
    val s: LiveData<ProfileViewState> = viewS


    fun validateInputs(name: String?, email: String?, password: String?) {
        viewS.value = ProfileViewState.ShowLoading
        if (name.isNullOrBlank() && email.isNullOrBlank() && password.isNullOrBlank()) {
            viewS.value = ProfileViewState.ShowErrorMessage
            return
        }
        if (name.isNullOrBlank()) {
            viewS.value = ProfileViewState.ShowNameErrorMessage
            return
        }
        if (email.isNullOrBlank()) {
            viewS.value = ProfileViewState.ShowEmailErrorMessage
            return
        }
        if (password.isNullOrBlank()) {
            viewS.value = ProfileViewState.ShowPasswordErrorMessage
            return
        }
        // if(email.contains("@") && (email.contains(".com"))
        //fazer uma extension com o booleano

        fetchLogin(name, email, password)
    }

    private fun fetchLogin(name: String, email: String, password: String) {
        viewS.value = ProfileViewState.ShowLoginScreen
    }

}
