package com.duany.campusparty

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.duany.campusparty.ui.GdinfoFragmentChartLine
import com.duany.campusparty.ui.GiinfoFragmentChartLine


class MyAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> GdinfoFragmentChartLine()
            1 -> GiinfoFragmentChartLine()
            else -> Fragment()
        }
    }

    override fun getCount(): Int {
        return 3 // Número de pestañas
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "GDI"
            1 -> "GII"
            else -> null
        }
    }
}