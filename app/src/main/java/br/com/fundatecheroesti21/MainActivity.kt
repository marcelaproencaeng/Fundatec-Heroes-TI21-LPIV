package br.com.fundatecheroesti21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //lateinit var car: Car
    //val car: Car by lazy {
    // Car(
    // rodas = 4,
//            portas = 2,
//            motor = "v8"
//        )
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editText)
        val btOk = findViewById<Button>(R.id.btok)
        val btLimpar = findViewById<Button>(R.id.btlimpar)
        val tvHello = findViewById<TextView>(R.id.tv_hello)
        btOk.setOnClickListener {
            tvHello.text = getString(R.string.hello, editText.text)
            tvHello.visibility = View.VISIBLE
        }
        btLimpar.setOnClickListener {
            tvHello.text = null
            tvHello.visibility = View.GONE
        }
    }
}


