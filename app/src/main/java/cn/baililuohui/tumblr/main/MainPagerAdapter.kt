package cn.baililuohui.tumblr.main

import android.content.Context
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MainPagerAdapter(var mContext: Context, fm: FragmentManager, var tabsTitle: List<TabsItem>): FragmentPagerAdapter(fm) {
//    private lateinit var mContext: Context
//    private lateinit var tabsTitle: String
    override fun getItem(position: Int): Fragment {
        return tabsTitle[position].fragment.newInstance()
    }

    override fun getCount(): Int {
        return tabsTitle.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabsTitle[position].name
    }
}