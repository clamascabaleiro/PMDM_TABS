package com.programa1.tabs.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.programa1.tabs.R
/**
 * Este es el array con el nombre de los Tabs
 * Las variables se guardan en el fichero strings.xml
 */
private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

/**
 *
 * Un [FragmentPagerAdapter] que
 * devuelve un Fragment correspondiente a una de las Sections/Tabs/Pages
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem es llamdo para instanciar un Fragment
        // usando el método newInstance de PlaceholderFragment
        return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Total de tabs que va mostrar (en este caso 3)
        return 2
    }
}