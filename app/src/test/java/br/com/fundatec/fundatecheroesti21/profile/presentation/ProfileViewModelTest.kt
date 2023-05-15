package br.com.fundatec.fundatecheroesti21.profile.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer

import br.com.fundatec.fundatecheroesti21.profile.presentation.model.ProfileViewState
import io.mockk.spyk
import io.mockk.verifySequence
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ProfileViewModelTest {
    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    private val viewModel: ProfileViewModel = ProfileViewModel()
    private val stateObserver: Observer<ProfileViewState> = spyk()

    @Test
    fun validate_inputs_when_null() {
        viewModel.validateInputs(null, null, null)

        Assert.assertEquals(viewModel.s.value, ProfileViewState.ShowErrorMessage)
    }

    @Test
    fun validate_sequenceViewState_inputs_when_null() {
        prepareScenario()
        viewModel.validateInputs(null, null, null)

        verifySequence {
            stateObserver.onChanged(ProfileViewState.ShowLoading)
            stateObserver.onChanged(ProfileViewState.ShowErrorMessage)
        }
    }

    @Test
    fun validate_inputs_when_not_null() {
        viewModel.validateInputs("marcela", "marcelap@gmail.com", "123456")

        Assert.assertEquals(viewModel.s.value, ProfileViewState.ShowHomeScreen)
    }

    private fun prepareScenario() {
        viewModel.s.observeForever(stateObserver)
    }

}
