package br.com.fundatecheroesti21.home.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.core.hide
import br.com.fundatec.core.show
import br.com.fundatecheroesti21.databinding.ActivityHomeBinding
import br.com.fundatecheroesti21.heroRegister.view.HeroRegisterActivity
import br.com.fundatecheroesti21.home.presentation.HomeViewModel
import br.com.fundatecheroesti21.home.presentation.model.CharacterModel
import br.com.fundatecheroesti21.home.presentation.model.HomeViewState

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by viewModels();
    private val characterListAdapter by lazy {
        CharacterListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.adapter = characterListAdapter

        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                HomeViewState.ShowError -> showError()
                is HomeViewState.ShowHome -> showHomeScreen(viewState.list)
                HomeViewState.ShowLoading -> showLoading()
                HomeViewState.ShowEmptyList -> showEmptyList()
            }
        }


        configButton()
    }

    override fun onResume() {
        super.onResume()
        viewModel.listCharacter()
    }

    private fun showHomeScreen(list: List<CharacterModel>) {
        binding.pbLoading.hide()
        characterListAdapter.add(list)
    }

    fun showEmptyList() {
        binding.pbLoading.hide()
    }

    fun showLoading() {
        binding.pbLoading.show()
    }

    private fun showError() {

    }

    private fun configButton() {
        binding.btCharacter.setOnClickListener {
            val intent = Intent(this@HomeActivity, HeroRegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
