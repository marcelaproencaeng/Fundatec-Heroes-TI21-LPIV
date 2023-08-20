package br.com.fundatecheroesti21.heroRegister.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatecheroesti21.character.data.domain.CharacterUseCase
import br.com.fundatecheroesti21.character.data.repository.CharacterRepository
import br.com.fundatecheroesti21.character.data.repository.CharacterRequest
import br.com.fundatecheroesti21.heroRegister.presentation.model.HeroRegisterViewState
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class HeroesRegisterViewModel : ViewModel() {
    private val viewState = MutableLiveData<HeroRegisterViewState>()
    val state: LiveData<HeroRegisterViewState> = viewState
    private val repository by lazy { CharacterRepository() }

    fun validateInputs(
        name: String?, description: String?, age: String?, birth_date: String?,
        select_heroType: String?, select_univerType: String?, url_image: String?
    ) {
        var patternAge = Pattern.compile("^(0|[1-9][0-9]*)$")
        var matcherAge = patternAge.matcher(age)

        var patternBirthDate = Pattern.compile("\\d{2}[-\\/\\.]\\d{2}[-\\/\\.]\\d{4}|\\d{8}")
        var matcherBirthDate = patternBirthDate.matcher(birth_date)


        viewState.value = HeroRegisterViewState.ShowLoading

        if (name.isNullOrBlank() && description.isNullOrBlank() && age.toString()
                .isNullOrBlank() && birth_date.toString().isNullOrBlank()
        ) {
            viewState.value = HeroRegisterViewState.ShowMessageError
            return
        }

        if (name.isNullOrBlank()) {
            viewState.value = HeroRegisterViewState.ShowNameError
            return
        }
        if (description.isNullOrBlank()) {
            viewState.value = HeroRegisterViewState.ShowDescriptionError
            return
        }
        if (!matcherAge.matches()) {
            viewState.value = HeroRegisterViewState.ShowAgeError
            return
        }

        if (age.isNullOrBlank() || age.equals("0")) {
            viewState.value = HeroRegisterViewState.ShowAgeError
            return
        }

        if (!matcherBirthDate.matches()) {
            viewState.value = HeroRegisterViewState.ShowBirthDateError
            return
        }

        if (birth_date.isNullOrBlank()) {
            viewState.value = HeroRegisterViewState.ShowNameError
            return
        }

        if (select_heroType.isNullOrEmpty()) {
            viewState.value = HeroRegisterViewState.ShowSelectHeroTypeError
            return
        }

        if (select_univerType.isNullOrEmpty()) {
            viewState.value = HeroRegisterViewState.ShowSelectUniverseTypeError
            return
        }



        fetchLogin(
            name,
            description,
            age,
            birth_date,
            select_heroType.uppercase(),
            select_univerType.uppercase(),
            url_image
        )
    }

    private fun fetchLogin(
        name: String?, description: String?, age: String?, birth_date: String?,
        select_heroType: String?, select_univerType: String?, url_image: String?
    ) {
        viewModelScope.launch {
            try {
                val character = CharacterRequest(
                    name = name ?: "",
                    description = description ?: "",
                    image = url_image ?: "",
                    universeType = select_univerType.toString().uppercase() ?: "",
                    characterType = select_heroType.toString().uppercase() ?: "",
                    age = age?.toIntOrNull() ?: 0,
                    birthday = birth_date ?: ""
                )
                val response = repository.addPersonagem(character)

                if (response) {
                    viewState.value = HeroRegisterViewState.ShowHomeScreen
                } else {
                    viewState.value = HeroRegisterViewState.ShowMessageError
                }
            } catch (e: Exception) {
                viewState.value = HeroRegisterViewState.ShowMessageError
            }
        }


    }
}


