package br.com.fundatecheroesti21.profile.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.core.hide
import br.com.fundatec.core.show
import br.com.fundatecheroesti21.profile.presentation.ProfileViewModel
import br.com.fundatecheroesti21.profile.presentation.model.ProfileViewState
import br.com.fundatecheroesti21.R
import br.com.fundatecheroesti21.databinding.ActivityProfileBinding
import br.com.fundatecheroesti21.login.view.LoginActivity
import com.google.android.material.snackbar.Snackbar

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeObserver()

        binding.btRgt.setOnClickListener {
            viewModel.validateInputs(
                name = binding.name.text.toString(),
                email = binding.email.text.toString(),
                password = binding.pwd.text.toString(),

                )
        }
    }

    private fun initializeObserver() {
        viewModel.s.observe(this) { viewS ->
            when (viewS) {
                ProfileViewState.ShowNameErrorMessage -> showNameError()
                ProfileViewState.ShowErrorMessage -> showSnackError()
                ProfileViewState.ShowEmailErrorMessage -> showEmailError()
                ProfileViewState.ShowPasswordErrorMessage -> showPasswordError()
                ProfileViewState.ShowLoading -> showLoading()
                ProfileViewState.ShowLoginScreen -> showLogin()
            }
        }
    }

    private fun showLoading() {
        binding.pbLoading.show()
    }

    private fun showNameError() {
        binding.pbLoading.hide()
        binding.name.error = getString(R.string.login_name_error_message)
    }

    private fun showEmailError() {
        binding.pbLoading.hide()
        binding.email.error = getString(R.string.login_email_error_message)
    }

    private fun showPasswordError() {
        binding.pbLoading.hide()
        binding.pwd.error = getString(R.string.login_password_error_message)

    }

    private fun showSnackError() {
        binding.pbLoading.hide()
        Snackbar.make(binding.root, R.string.login_error_message, Snackbar.LENGTH_LONG).show()
    }

    //Tela para cadastro do usuário,
    // ao cadastrar um novo usuário devemos ser
    // redirecionados para a tela de login utilizando o finish()
    private fun showLogin() {
        binding.pbLoading.hide()
        startActivity(Intent(this@ProfileActivity, LoginActivity::class.java))
        finish()
    }


    // fun main (args : Array<String>){
    //   val chars = listOf<String>("@",".com")
    // val pattern ="@".toRegex()
    //  val pattern2 =".com".toRegex()
    //  chars.forEach(){ char ->
    // if(pattern.containsMatchIn(char) ){
    //  println("$ char matches")
    //  }
    //  if(pattern2.containsMatchIn(char)){
    //    println("$ char matches")
    //   }
    //   }

    //  }
}
