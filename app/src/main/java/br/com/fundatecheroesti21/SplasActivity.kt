package br.com.fundatecheroesti21

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_splash)

        val handle = Handler()
        handle.postDelayed(
            Runnable() {
                mostrarLogin()
            }, 3000
        )
    }


    private fun mostrarLogin() {
        val intent = Intent(this@SplashActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}