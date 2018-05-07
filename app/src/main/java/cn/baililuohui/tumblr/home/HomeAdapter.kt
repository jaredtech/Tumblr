package cn.baililuohui.tumblr.home

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.baililuohui.tumblr.R

class HomeAdapter(var context: Context, var data: ArrayList<String>): RecyclerView.Adapter<HomeAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_blog, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

    }

    class MyHolder(view: View): RecyclerView.ViewHolder(view) {
        init {
        }
    }
}