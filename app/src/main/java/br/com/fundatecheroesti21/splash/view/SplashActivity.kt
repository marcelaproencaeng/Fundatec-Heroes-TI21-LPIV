package br.com.fundatecheroesti21

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatecheroesti21.home.view.HomeActivity
import br.com.fundatecheroesti21.login.view.LoginActivity
import br.com.fundatecheroesti21.splash.presentation.SplashViewModel
import br.com.fundatecheroesti21.splash.view.SplashViewState


class SplashActivity : AppCompatActivity() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        private fun initializeObserver(){
            viewModel.state.observe(this) { viewState ->
                when (viewState) {
                    SplashViewState.ShowHomeScreen -> showHomeScreen()
                    SplashViewState.ShowLoginScreen -> showLoginScreen()
                }
            }
        }
    }

    private fun showHome() {
        startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
        finish()
    }

    private fun showLogin() {
        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        finish()
    }
//    private lateinit var binding: ActivityLoginBinding
//
//    private val viewModel: LoginViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        initializeObserver()
//
//        binding.btLogin.setOnClickListener {
//            viewModel.validateInputs(
//                password = binding.pwd.text.toString(),
//                email = binding.email.text.toString(),
//            )
//        }
//
//        binding.tvNewHere.setOnClickListener {
//            showProfile()
//        }
//    }
//
//    private fun initializeObserver() {
//        viewModel.state.observe(this) { viewState ->
//            when (viewState) {
//                SplashViewState.ShowHomeScreen -> showHomeScreen()
//                SplashViewState.ShowLoginScreen -> showLoginScreen()
//
////                LoginViewState.ShowLoading -> showLoading()
//            }
//        }
//    }
//
//    //    private fun showLoading() {
////        binding.pbLoading.show()
////    }
//    private fun showHomeScreen() {
//        binding.pbLoading.hide()
//        val intent = Intent(this@SplashActivity, HomeActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
//
//
//    private fun showLoginScreen() {
//        val intent = Intent(this@SplashActivity, LoginActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
//
//
////        viewModel.state.observe
////
////    val handle = Handler()
////    handle.postDelayed(
////    Runnable()
////    {
////        mostrarLogin()
////    }, 3000
////    )
////}


}