package br.com.fundatecheroesti21.heroRegister.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatecheroesti21.R
import br.com.fundatecheroesti21.databinding.ActivityHeroRegisterBinding
import br.com.fundatecheroesti21.heroRegister.presentation.HeroesRegisterViewModel
import br.com.fundatecheroesti21.heroRegister.presentation.model.HeroRegisterViewState
import com.google.android.material.snackbar.Snackbar

class HeroRegisterActivity : AppCompatActivity() {
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
                is
                HeroRegisterViewState.ShowHomeScreen -> showHome()
                HeroRegisterViewState.ShowLoading -> showLoading()
                HeroRegisterViewState.ShowNameError -> showNameError()
                HeroRegisterViewState.ShowMessageError -> showSnackError()
                HeroRegisterViewState.ShowDescriptionError -> showDescriptionError()
                HeroRegisterViewState.ShowAgeError -> showAgeError()
                HeroRegisterViewState.ShowBirthDateError -> showBirthDateError()
                HeroRegisterViewState.ShowSelectUniverseTypeError -> showSelectUniverseTypeError()
                HeroRegisterViewState.ShowSelectHeroTypeError -> showSelectHeroType()
                HeroRegisterViewState.ShowUrlImageError -> showUrlImageError()
                HeroRegisterViewState.ShowActionError -> showActionError()
            }
        }
    }

    private fun showActionError() {
        binding.pbLoading.hide()
        errorMessages(binding.root, getString(R.string.action_error))
    }

    private fun showUrlImageError() {
        binding.pbLoading.hide()
        binding.age.error = getString(R.string.url_error_message)
    }

    private fun showSelectHeroType() {
        binding.pbLoading.hide()
        binding.age.error = getString(R.string.hero_error_message)
    }

    private fun showSelectUniverseTypeError() {
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
        Snackbar.make(
            binding.root,
            R.string.login_error_message_hero_register,
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun showDescriptionError() {
        binding.pbLoading.hide()
        binding.description.error = getString(R.string.register_description_error_message)
    }
}
