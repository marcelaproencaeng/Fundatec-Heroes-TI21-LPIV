package br.com.fundatecheroesti21.character

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.annotation.ArrayRes
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.core.hide
import br.com.fundatec.core.show
import br.com.fundatecheroesti21.R
import br.com.fundatecheroesti21.home.presentation.CharacterViewModel
import br.com.fundatecheroesti21.databinding.ActivityCharacterBinding
import br.com.fundatecheroesti21.home.presentation.model.CharacterViewState
import br.com.fundatecheroesti21.login.view.LoginActivity
import com.google.android.material.snackbar.Snackbar

class CharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterBinding
    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeObserver()
        configAdapterSpinner(R.array.heroes_marvel_dc_array, binding.spinnerMarvelDc)
        configAdapterSpinner(R.array.heroes_villains_array, binding.spinnerHeroesType)

        binding.fab.setOnClickListener {
            viewModel.validateInputs(
                name = binding.hName.text.toString(),
                description = binding.hDescription.text.toString(),
                age = binding.hAge.text.toString(),
                date = binding.hDate.text.toString(),
                url = binding.hUrl.text.toString(),
            )
        }
    }

    private fun configAdapterSpinner(@ArrayRes listResId: Int, spinner: Spinner) {
        ArrayAdapter.createFromResource(
            this,
            listResId,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    private fun initializeObserver() {
        viewModel.s.observe(this) { viewS ->
            when (viewS) {
                CharacterViewState.ShowLoginScreen -> showLogin()
                CharacterViewState.ShowErrorMessage -> showSnackError()
                CharacterViewState.ShowNameErrorMessage -> showNameError()
                CharacterViewState.ShowDescriptionErrorMessage -> showDescriptionError()
                CharacterViewState.ShowAgeErrorMessage -> showAgeError()
                CharacterViewState.ShowDateErrorMessage -> showDateError()
                CharacterViewState.ShowUrlErrorMessage -> showUrlError()
                CharacterViewState.ShowLoading -> showLoading()
            }
        }
    }

    private fun showDateError() {
        binding.pbLoading.hide()
        binding.date.error = "Data inválida!"
    }

    private fun showAgeError() {
        binding.pbLoading.hide()
        binding.age.error = "Idade inválida!"
    }

    private fun showUrlError() {
        binding.pbLoading.hide()
        binding.hUrl.error = "Url inválida!"
    }


    private fun showDescriptionError() {
        binding.pbLoading.hide()
        binding.description.error = "Descrição inválida!"
    }

    private fun showNameError() {
        binding.pbLoading.hide()
        binding.name.error = getString(R.string.login_name_error_message)
    }

    private fun showSnackError() {
        binding.pbLoading.hide()
        Snackbar.make(binding.root, R.string.character_error_message, Snackbar.LENGTH_LONG).show()
    }

    private fun showLoading() {
        binding.pbLoading.show()
    }

    private fun showLogin() {
        binding.pbLoading.hide()
        val intent = Intent(this@CharacterActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}

