package cn.baililuohui.tumblr.main

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.baililuohui.tumblr.MessageFragment
import cn.baililuohui.tumblr.R
import cn.baililuohui.tumblr.SearchFragment
import cn.baililuohui.tumblr.home.HomeFragment
import cn.baililuohui.tumblr.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabsItems = ArrayList<TabsItem>()

        tabsItems.add(TabsItem("首页", HomeFragment::class.java))
        tabsItems.add(TabsItem("搜索", SearchFragment::class.java))
        tabsItems.add(TabsItem("消息", MessageFragment::class.java))
        tabsItems.add(TabsItem("我", ProfileFragment::class.java))

        homePager.adapter = MainAdapter(this, supportFragmentManager, tabsItems)
        homeTabs.setupWithViewPager(homePager)
    }

    companion object {
        fun go(activity: Activity) {
            activity.startActivity(Intent(activity, MainActivity::class.java))
        }
    }
}
