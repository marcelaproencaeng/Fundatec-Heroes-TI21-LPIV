package br.com.fundatecheroesti21.heroRegister.view


import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.databinding.DataBindingUtil.setContentView
import br.com.fundatecheroesti21.R
import br.com.fundatecheroesti21.heroRegister.presentation.HeroesRegisterViewModel
import br.com.fundatecheroesti21.heroRegister.presentation.model.HeroRegisterViewState

class HeroRegisterActivity {
    private lateinit var binding: ActivityHeroRegisterBinding
    private val viewModel: HeroesRegisterViewModel by viewModels();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeObserver()
        binding.floatingButton.setOnClickListener {
            viewModel.validateInputs(
                name = binding.nameHero.text.toString(),
                description = binding.description.text.toString(),
                age = binding.age.text.toString(),
                birth_date = binding.birthDate.text.toString(),
                select_heroType = binding.selectHero.onItemSelectedListener.toString(),
                select_univerType = binding.selectUniverse.onItemSelectedListener.toString(),
                url_image = binding.imgHero.text.toString()
            )
        }
    }
    private fun initializeObserver() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                is HeroRegisterViewState.ShowHomeScreen -> showHome()
                HeroRegisterViewState.ShowLoading -> showLoading()
                HeroRegisterViewState.ShowNameError -> showNameError()
                HeroRegisterViewState.ShowMessageError -> showSnackError()
                HeroRegisterViewState.ShowDescriptionError -> showDescriptionError()
                HeroRegisterViewState.ShowAgeError -> showAgeError()
                HeroRegisterViewState.ShowBirthDateError -> showBirthDateError()
                HeroRegisterViewState.ShowisSucess -> showIsSucess()
                HeroRegisterViewState.ShowSelectUniverseTypeError -> showSelectUniverseTypeError()
                HeroRegisterViewState.ShowSelectHeroTypeError -> showSelectHeroType()
                HeroRegisterViewState.ShowUrlImageError -> showUrlImageError()
            }
        }
    }


    private fun initializeObserver() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                is HeroRegisterViewState.ShowHomeScreen -> showHome()
                HeroRegisterViewState.ShowLoading -> showLoading()
                HeroRegisterViewState.ShowNameError -> showNameError()
                HeroRegisterViewState.ShowMessageError -> showSnackError()
                HeroRegisterViewState.ShowDescriptionError -> showDescriptionError()
                HeroRegisterViewState.ShowAgeError -> showAgeError()
                HeroRegisterViewState.ShowBirthDateError -> showBirthDateError()
                HeroRegisterViewState.ShowisSucess -> showIsSucess()
                HeroRegisterViewState.ShowSelectUniverseTypeError -> showSelectUniverseTypeError()
                HeroRegisterViewState.ShowSelectHeroTypeError -> showSelectHeroType()
                HeroRegisterViewState.ShowUrlImageError -> showUrlImageError()
            }
        }
    }





    private fun showUrlImageError() {
        TODO("Not yet implemented")
        binding.pbLoading.hide()
        binding.age.error = getString(R.string.url_error_message)
    }

    private fun showSelectHeroType() {
        TODO("Not yet implemented")
        binding.pbLoading.hide()
        binding.age.error = getString(R.string.hero_error_message)
    }

    private fun showSelectUniverseTypeError() {
        TODO("Not yet implemented")
    }

    private fun showIsSucess() {
        TODO("Not yet implemented")
        binding.pbLoading.hide()
        binding.age.error = getString(R.string.universe_error_message)
    }

    private fun showLoading() {
        binding.pbLoading.show()
    }
    private fun showAgeError() {
        binding.pbLoading.hide()
        binding.age.error = getString(R.string.register_age_error_message)
    }
    private fun showBirthDateError() {
        binding.pbLoading.hide()
        binding.birthDate.error = getString(R.string.register_birthDate_error_message)
    }
    private fun showNameError() {
        binding.pbLoading.hide()
        binding.nameHero.error = getString(R.string.register_name_error_message)
    }
    private fun showHome() {
        binding.pbLoading.hide()
        val intent = Intent(this@HeroRegisterActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun showSnackError() {
        binding.pbLoading.hide()
        Snackbar.make(binding.root, R.string.login_error_message_hero_register, Snackbar.LENGTH_LONG).show()
    }
    private fun showDescriptionError() {
        binding.pbLoading.hide()
        binding.description.error = getString(R.string.register_description_error_message)
    }
}
