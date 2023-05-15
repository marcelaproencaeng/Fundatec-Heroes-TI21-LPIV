package br.com.fundatec.fundatecheroesti21

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.fundatec.fundatecheroesti21.login.presentation.LoginViewModel
import br.com.fundatec.fundatecheroesti21.login.presentation.model.LoginViewState
import br.com.fundatec.fundatecheroesti21.profile.presentation.ProfileViewModel
import br.com.fundatec.fundatecheroesti21.profile.presentation.model.ProfileViewState
import io.mockk.spyk
import io.mockk.verifySequence
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Rule

class ProfileViewModelTest2 {
    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    private val viewModel = ProfileViewModel()
    private val stateObserver: Observer<ProfileViewState> = spyk()

    @Test
    fun validateViewState_returnShowErrorEmptyFields() {
        prepareScenario()
        viewModel.validateInputs(null,null,null)

        assertEquals(viewModel.s.value, ProfileViewState.ShowLoading)
    }

    @Test
    fun callProfile_verifyIsCalledProfileDataSource()  {
        prepareScenario()
        viewModel.validateInputs("nome","email","password")

//        assertEquals(viewModel.s.value, ProfileViewState.ShowHomeScreen)
        verifySequence {
            stateObserver.onChanged(ProfileViewState.ShowLoading)
            stateObserver.onChanged(ProfileViewState.ShowHomeScreen)
        }
    }

    private fun prepareScenario() {
        viewModel.s.observeForever(stateObserver)
    }
}