package br.com.fundatecheroesti21.home.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatecheroesti21.databinding.ActivityHomeBinding
import br.com.fundatecheroesti21.heroRegister.view.HeroRegisterActivity
import br.com.fundatecheroesti21.home.presentation.HomeViewModel
import br.com.fundatecheroesti21.home.presentation.model.HomeViewState

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val adapter by lazy { CharacterListAdapter() }
    private val viewModel: HomeViewModel by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.adapter = adapter

        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                HomeViewState.ShowError -> showError()
                is HomeViewState.ShowHome -> adapter.add(viewState.list)
                HomeViewState.ShowLoading -> showLoading()
            }
        }

        configButton()
    }

    private fun showError() {

    }

    private fun showLoading() {

    }

    private fun configButton() {
        binding.btCharacter.setOnClickListener {
            val intent = Intent(this@HomeActivity, HeroRegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
