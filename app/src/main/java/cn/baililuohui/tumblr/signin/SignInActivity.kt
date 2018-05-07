package cn.baililuohui.tumblr.signin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import cn.baililuohui.tumblr.Constant
import cn.baililuohui.tumblr.main.MainActivity
import cn.baililuohui.tumblr.R
import cn.baililuohui.tumblr.utils.SPUtils
import kotlinx.android.synthetic.main.activity_sign_in.*
import oauth.signpost.OAuthConsumer
import oauth.signpost.basic.DefaultOAuthConsumer
import oauth.signpost.basic.DefaultOAuthProvider
import oauth.signpost.exception.OAuthCommunicationException
import oauth.signpost.exception.OAuthExpectationFailedException
import oauth.signpost.exception.OAuthMessageSignerException
import oauth.signpost.exception.OAuthNotAuthorizedException

class SignInActivity : AppCompatActivity() {

    private lateinit var consumer: OAuthConsumer
    private lateinit var provider: DefaultOAuthProvider

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        consumer = DefaultOAuthConsumer(Constant.REST_CONSUMER_KEY, Constant.REST_CONSUMER_SECRET)
        provider = DefaultOAuthProvider(Constant.REQUEST_TOKEN_URL, Constant.ACCESS_TOKEN_URL, Constant.AUTHORIZE_URL)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Snackbar.make(webView, "正在加载授权页面", Toast.LENGTH_SHORT).show()
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                super.onReceivedSslError(view, handler, error)
                handler?.proceed()
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                val contains = url?.contains(Constant.CALLBACK_URL) ?: false
                if (contains) {
                    val token = getValueByName(url, "oauth_token")
                    val verificode = getValueByName(url, "oauth_verifier")
                    val task = AccessTask()
                    task.execute(verificode)
                    view?.stopLoading()
                }
                view?.loadUrl(url)
                return true
            }
        }

        MyAsynctask().execute()
    }

    @SuppressLint("StaticFieldLeak")
    inner class MyAsynctask : AsyncTask<String, Any, String>() {
        var url: String = ""
        override fun doInBackground(vararg p0: String?): String {
            try {
                url = provider.retrieveRequestToken(consumer, Constant.CALLBACK_URL)
            }catch (e: Exception){
                e.printStackTrace()
            }
            return url
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            result?.let {
                webView.loadUrl(result)
            }
        }
    }

    /*
  * 授权完成 获取有效token
  * */
    inner class AccessTask : AsyncTask<String, String, Int?>() {

        override fun doInBackground(vararg params: String): Int? {
            val verifiCode = params[0].substring(0, params[0].length - 4)
            try {
                provider.retrieveAccessToken(consumer, verifiCode)
                val token = consumer.token
                val tokenScret = consumer.tokenSecret
                SPUtils.put(Constant.TOKEN, token)
                SPUtils.put(Constant.TOKEN_SECRET, tokenScret)
                SPUtils.put(Constant.LOGIN, true)
                Log.d("登录","授权成功")
            } catch (e: OAuthMessageSignerException) {
                e.printStackTrace()
            } catch (e: OAuthNotAuthorizedException) {
                e.printStackTrace()
            } catch (e: OAuthExpectationFailedException) {
                e.printStackTrace()
            } catch (e: OAuthCommunicationException) {
                e.printStackTrace()
            }

            return null
        }

        override fun onPostExecute(result: Int?) {
            MainActivity.go(this@SignInActivity)
        }
    }

    companion object {
        fun go(activity: Activity, edit: Boolean = false) {
            activity.startActivity(Intent(activity, SignInActivity::class.java))
//            ActivityCompat.startActivity(activity,
//                    Intent(activity, SignInActivity::class.java),
//                    ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle())
        }

        private fun getValueByName(data: String?, name: String): String {
            var result = ""
            val index = data?.indexOf("?") ?: 0
            val temp = data?.substring(index + 1)
            val keyValue = temp?.split("&")
            keyValue?.forEach {
                if (it.contains(name)) {
                    result = it.replace("$name=", "")
                    return@forEach
                }
            }
            return result
        }
    }
}
