package br.com.fundatecheroesti21.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatecheroesti21.login.domain.LoginUseCase
import br.com.fundatecheroesti21.profile.presentation.model.ProfileViewState
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class ProfileViewModel : ViewModel() {
    private val viewS = MutableLiveData<ProfileViewState>()
    val s: LiveData<ProfileViewState> = viewS
    private val usecase by lazy { LoginUseCase() }


    fun validateInputs(name: String?, email: String?, password: String?) {
        var patternEmail = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")
        var matcherEmail = patternEmail.matcher(email)

        if (name.isNullOrBlank() && email.isNullOrBlank() && password.isNullOrBlank()) {
            viewS.value = ProfileViewState.ShowErrorMessage
            return
        }

        if (name.isNullOrBlank()) {
            viewS.value = ProfileViewState.ShowNameErrorMessage
            return
        }
        if (!matcherEmail.matches()) {
            viewS.value = ProfileViewState.ShowEmailErrorMessage
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

        fetchLogin(name, email, password)
    }

    private fun fetchLogin(name: String, email: String, password: String) {
        viewS.value = ProfileViewState.ShowLoading

        viewModelScope.launch {
            val isCreated = usecase.createUser(name, email, password)

            if (isCreated) {
                viewS.value = ProfileViewState.ShowLoginScreen
            } else {
                viewS.value = ProfileViewState.ShowErrorMessage
            }
        }
    }
}


