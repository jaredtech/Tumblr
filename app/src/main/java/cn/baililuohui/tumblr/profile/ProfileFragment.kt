package cn.baililuohui.tumblr.profile


import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.baililuohui.tumblr.Constant

import cn.baililuohui.tumblr.R
import cn.baililuohui.tumblr.utils.SPUtils
import com.tumblr.jumblr.JumblrClient
import com.tumblr.jumblr.types.User

class ProfileFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    private val TAG = ProfileFragment::class.java.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userTask = @SuppressLint("StaticFieldLeak")
        object: AsyncTask<Any, Any, User>(){
            var token: String? = null
            var secret: String? = null
            override fun onPreExecute() {
                token = SPUtils.getString(Constant.TOKEN, "")
                secret = SPUtils.getString(Constant.TOKEN_SECRET, "")
                super.onPreExecute()
            }
            override fun doInBackground(vararg p0: Any?): User {
                val client = JumblrClient(Constant.REST_CONSUMER_KEY, Constant.REST_CONSUMER_SECRET)
                client.setToken(token, secret)
                client.userDashboard()
                return client.user()
            }

            override fun onPostExecute(result: User?) {
                super.onPostExecute(result)
                result?.let {
                    Log.d(TAG, it.name)
                    Log.d(TAG, it.defaultPostFormat)
                    Log.d(TAG, "it.likeCount")
                    Log.d(TAG, it.name)
                }
            }
        }
        userTask.execute()
    }

    companion object {
        @JvmStatic
        val newInstance = ProfileFragment()
    }
}
