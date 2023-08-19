package br.com.fundatecheroesti21.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatecheroesti21.home.domain.GetCharacterListUseCase
import br.com.fundatecheroesti21.home.presentation.model.HomeViewState
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val viewState = MutableLiveData<HomeViewState>()
    val state: LiveData<HomeViewState> = viewState
    private val useCase by lazy { GetCharacterListUseCase() }


    fun listCharacter() {
        viewState.value = HomeViewState.ShowLoading
        viewModelScope.launch {
            val list = useCase.listCharacter()
            if (list.isEmpty()) {
                viewState.value = HomeViewState.ShowError
            } else {
                viewState.value = HomeViewState.ShowHome(list)
            }
        }
    }
}





