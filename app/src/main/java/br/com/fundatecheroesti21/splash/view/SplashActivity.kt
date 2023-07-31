package br.com.fundatecheroesti21.splash.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatecheroesti21.R
import br.com.fundatecheroesti21.home.view.HomeActivity
import br.com.fundatecheroesti21.login.view.LoginActivity
import br.com.fundatecheroesti21.splash.presentation.SplashViewModel
import br.com.fundatecheroesti21.splash.presentation.model.SplashViewState

internal class SplashActivity :AppCompatActivity(){
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//         fun initializeObserver(){
        viewModel.splash.observe(this) { viewState ->
            when (viewState) {
                SplashViewState.ShowHomeScreen -> showHome()
                SplashViewState.ShowLoginScreen -> showLogin()
            }
        }
//        }
    }

    private fun showHome() {
        startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
        finish()
    }
//Tela de splash deve consultar no banco de dados se já existe um usuário
// se existir e o tempo do ultimo login for maior que 10 minutos devemos
// levar o usuário para a tela de login,
// caso não exista o usuário no banco de dados
// devemos levar o usuário direto para tela de login
    private fun showLogin() {
        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        finish()
    }
}