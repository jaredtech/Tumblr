package cn.baililuohui.tumblr.welcome

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.baililuohui.tumblr.Constant
import cn.baililuohui.tumblr.main.MainActivity
import cn.baililuohui.tumblr.R
import cn.baililuohui.tumblr.signin.SignInActivity
import cn.baililuohui.tumblr.utils.SPUtils

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        if (!SPUtils.getBoolean(Constant.LOGIN, false)) {
            SignInActivity.go(this)
        } else {
            MainActivity.go(this)
        }
        finish()
    }
}
