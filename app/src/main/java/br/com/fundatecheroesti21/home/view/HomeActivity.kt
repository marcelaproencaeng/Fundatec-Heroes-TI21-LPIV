package br.com.fundatecheroesti21.home.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatecheroesti21.character.CharacterActivity
import br.com.fundatecheroesti21.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = HomeViewPager(supportFragmentManager)
        binding.homeViewPager.adapter = adapter
        binding.homeTabLayout.setupWithViewPager(binding.homeViewPager)

        binding.btCharacter.setOnClickListener {
            startActivity(Intent(this@HomeActivity,CharacterActivity::class.java))
        }

        configButton()
    }

    private fun configButton() {
        binding.btCharacter.setOnClickListener {
            val intent = Intent(this@HomeActivity, CharacterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
