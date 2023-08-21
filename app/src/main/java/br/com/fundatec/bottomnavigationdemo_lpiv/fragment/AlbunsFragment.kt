package br.com.fundatec.bottomnavigationdemo_lpiv.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import br.com.fundatec.bottomnavigationdemo_lpiv.R

class AlbunsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_albuns, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance(): Fragment {
            return AlbunsFragment()
        }
    }
}
