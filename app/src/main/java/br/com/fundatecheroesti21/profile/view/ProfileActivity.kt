package br.com.fundatecheroesti21.profile.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.core.hide
import br.com.fundatec.core.show
import br.com.fundatecheroesti21.R
import br.com.fundatecheroesti21.databinding.ActivityProfileBinding
import br.com.fundatecheroesti21.profile.presentation.ProfileViewModel
import br.com.fundatecheroesti21.profile.presentation.model.ProfileViewState
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
//    Agora todas as nossas telas vão ser integradas com a api
//
//Tela para cadastro do usuário, ao cadastrar um novo usuário devemos ser redirecionado para a tela de login utilizando o finish()
//Tela de splash deve consultar no banco de dados se já existe um usuário se existir e o tempo do ultimo login
// for maior que 10 minutos devemos levar o usuário para a tela de login, caso não exista o usuário no banco de dados
// devemos levar o usuário direto para tela de login
//Tela de login, ao fazer o login devemos salvar o id do usuário no banco de dados, pois vamos precisar desse id para salvar/buscar/deletar os personagens
//Tela de cadastro de um personagem agora deve salvar o personagem na api, após salvar um novo personagem devemos limpar a tabela utilizada como cache e devemos navegar para a tela de home.
//Tela de listagem deve listar o personagem buscando os dados da API, nessa tela iremos utilizar o viewpager(tabs) para ter a separação dos personagens que são heróis ou vilões, antes de buscar na api devemos verificar se já existe uma lista de personagens no banco de dados, caso não exista devemos buscar na API, também possuimos uma regra onde devemos verificar se o cache foi preenchido a mais de 10 minutos caso tenha não devemos buscar as informações no cache e sim na api.
//Devemos adicionar uma implementação nos cards que ao realizar um swipe nós devemos remover o personagem da lista e remover ele chamando a API reponsavel por deletar
//Todas as interações com a api devem possuir um loader na app.
}
