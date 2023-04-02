package br.com.fundatecheroesti21

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editSenha = findViewById<EditText>(R.id.editSenha)
        val btLogin = findViewById<Button>(R.id.btLogin)
        val cadastro = findViewById<TextView>(R.id.cadastrar)



        btLogin.setOnClickListener {
            val l = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(l)
        }
        cadastro.setOnClickListener {
            val c = Intent(this@LoginActivity, ProfileActivity::class.java)
            startActivity(c)
        }


    }
}

