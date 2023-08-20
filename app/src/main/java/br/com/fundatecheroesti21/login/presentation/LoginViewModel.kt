package br.com.fundatecheroesti21.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatecheroesti21.login.domain.LoginUseCase
import br.com.fundatecheroesti21.login.presentation.model.LoginViewState
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class LoginViewModel : ViewModel() {

    private val useCase by lazy { LoginUseCase() }
    private val viewState = MutableLiveData<LoginViewState>()
    val state: LiveData<LoginViewState> = viewState

    fun validateInputs(email: String?, password: String?) {
        viewState.value = LoginViewState.ShowLoading
        var patternEmail = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")
        var matcherEmail = patternEmail.matcher(email)

        if (email.isNullOrBlank() && password.isNullOrBlank()) {
            viewState.value = LoginViewState.ShowErrorMessage
            return
        }
        if (!matcherEmail.matches()) {
            viewState.value = LoginViewState.ShowEmailErrorMessage
            return
        }

        if (email.isNullOrBlank()) {
            viewState.value = LoginViewState.ShowEmailErrorMessage
            return
        }

        if (password.isNullOrBlank()) {
            viewState.value = LoginViewState.ShowPasswordErrorMessage
            return
        }

        fetchLogin(email, password)
    }

    private fun fetchLogin(email: String, password: String) {
        viewModelScope.launch {
            val isSuccess = useCase.login(email = email, password = password)
            if (isSuccess) {
                viewState.value = LoginViewState.ShowHomeScreen
            } else {
                viewState.value = LoginViewState.ShowErrorMessage
            }
        }
    }


}