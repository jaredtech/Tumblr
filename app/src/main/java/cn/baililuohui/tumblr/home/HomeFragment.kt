package cn.baililuohui.tumblr.home


import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.baililuohui.tumblr.Constant

import cn.baililuohui.tumblr.R
import cn.baililuohui.tumblr.utils.SPUtils
import com.tumblr.jumblr.JumblrClient
import com.tumblr.jumblr.types.PhotoPost
import com.tumblr.jumblr.types.Post
import com.tumblr.jumblr.types.VideoPost
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var client: JumblrClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private val TAG: String = HomeFragment::class.java.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = ArrayList<String>()
        for (i in 0 until 10) {
            data.add("data$i")
        }
        val dashboardTask = @SuppressLint("StaticFieldLeak")
        object : AsyncTask<Any, Any, List<Post>>() {
            var token: String? = null
            var secret: String? = null
            override fun onPreExecute() {
                token = SPUtils.getString(Constant.TOKEN, "")
                secret = SPUtils.getString(Constant.TOKEN_SECRET, "")
                super.onPreExecute()
            }
            override fun doInBackground(vararg params: Any?): List<Post> {
                client = JumblrClient(Constant.REST_CONSUMER_KEY, Constant.REST_CONSUMER_SECRET)
                client.setToken(token, secret)
                client.userDashboard()
                return client.userDashboard()
            }

            override fun onPostExecute(result: List<Post>?) {
                super.onPostExecute(result)
                testJson.text = client.data
                result?.forEach {
                    val link = when(it.type){
                        Post.PostType.VIDEO ->{
                            val videoPost = it as VideoPost
                            if (videoPost.permalinkUrl == null) {
//                                videoPost.videos.forEach {
//                                    Log.d(TAG, it.embedCode)
//                                }
                            }else {
                                Log.d(TAG, videoPost.permalinkUrl)
                            }
                        }
                        Post.PostType.PHOTO -> Log.d(TAG, (it as PhotoPost).photos[0].originalSize.url)
                        else -> Log.d(TAG, it.type.name)
                    }
                }
            }
        }
        dashboardTask.execute()
//        homeRecycler.layoutManager = LinearLayoutManager(context)
//        homeRecycler.adapter = HomeAdapter(context!!, data)
//        PagerSnapHelper().attachToRecyclerView(homeRecycler)
    }

    companion object {
        @JvmStatic
        val newInstance = HomeFragment()
    }
}
