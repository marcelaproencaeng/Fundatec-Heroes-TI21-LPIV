package br.com.fundatecheroesti21.home.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import br.com.fundatecheroesti21.character.view.CharacterFragment

class HomeViewPager(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Fragment $position"
    }

    override fun getItem(position: Int): Fragment {
        return CharacterFragment.newInstance("Fragment $position")
    }
}