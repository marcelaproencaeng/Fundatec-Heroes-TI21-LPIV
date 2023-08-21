package br.com.fundatec.bottomnavigationdemo_lpiv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import br.com.fundatec.bottomnavigationdemo_lpiv.fragment.AlbunsFragment
import br.com.fundatec.bottomnavigationdemo_lpiv.fragment.ArtistasFragment
import br.com.fundatec.bottomnavigationdemo_lpiv.fragment.MusicasFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var navigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationView = findViewById<View>(R.id.navigationView) as BottomNavigationView
        navigationView!!.setOnNavigationItemSelectedListener(this)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_songs -> {
                supportActionBar!!.title = "Músicas"
                val musicasFragment = MusicasFragment.newInstance()
                openFragment(musicasFragment)
            }
            R.id.navigation_albums -> {
                supportActionBar!!.setTitle("Álbuns")
                val albunsFragment: Fragment = AlbunsFragment.newInstance()
                openFragment(albunsFragment)
            }
            R.id.navigation_artists -> {
                supportActionBar!!.setTitle("Artistas")
                val artistasFragment: Fragment = ArtistasFragment.newInstance()
                openFragment(artistasFragment)
            }
        }
        return true
    }


    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}