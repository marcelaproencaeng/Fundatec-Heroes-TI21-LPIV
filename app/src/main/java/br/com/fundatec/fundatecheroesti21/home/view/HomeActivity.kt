package br.com.fundatec.fundatecheroesti21.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheroesti21.databinding.ActivityProfileBinding
import br.com.fundatec.fundatecheroesti21.home.presentation.HomeViewModel
import br.com.fundatec.fundatecheroesti21.home.presentation.model.HomeViewState
import br.com.fundatec.fundatecheroesti21.profile.presentation.ProfileViewModel
import br.com.fundatec.fundatecheroesti21.profile.presentation.model.ProfileViewState

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeObserver()

        binding.btCriar.setOnClickListener {
            viewModel.validateInputs(
                name = binding.name.text.toString(),
                description = binding.description.text.toString(),
                age = binding.age.text.toString(),
                date = binding.date.text.toString(),


                )
        }

    }
    private fun initializeObserver() {
        viewModel.s.observe(this) { viewS ->
            when (viewS) {
                HomeViewState.ShowHomeScreen -> showHome()
                HomeViewState.ShowErrorMessage -> showSnackError()
                HomeViewState.ShowNameErrorMessage -> showNameError()

                HomeViewState.ShowDescriptionErrorMessage -> showDescriptionError()
                HomeViewState.ShowAgeErrorMessage -> showAgeError()
                HomeViewState.ShowDateErrorMessage ->showDateError()
                HomeViewState.ShowLoading -> showLoading()
            }
        }
    }
}
