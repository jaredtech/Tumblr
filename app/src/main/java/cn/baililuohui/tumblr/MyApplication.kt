package cn.baililuohui.tumblr

import android.app.Application

class MyApplication: Application() {

    companion object {
        private val TAG = MyApplication::class.java.simpleName
        lateinit var application: MyApplication
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}