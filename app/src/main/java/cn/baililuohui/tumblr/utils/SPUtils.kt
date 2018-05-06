package cn.baililuohui.tumblr.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import cn.baililuohui.tumblr.Constant
import cn.baililuohui.tumblr.MyApplication

class SPUtils {
    companion object {
        public val fileName = "default_config"

        fun getSPreference(): SharedPreferences{
            return getSPreferrence(MyApplication.application, fileName)
        }

        fun getSPreferrence(context: Context, fileName: String): SharedPreferences {
            return context.getSharedPreferences(fileName, Activity.MODE_PRIVATE)
        }

        fun getString(key: String, defaultValue: String): String {
            return getSPreference().getString(key, defaultValue)
        }

        fun getInt(key: String, defaultValue: Int): Int {
            return getSPreference().getInt(key, defaultValue)
        }

        fun getBoolean(key: String, defaultValue: Boolean): Boolean {
            return getSPreference().getBoolean(key, defaultValue)
        }

        fun put(key: String, value: Any) {
            val editor = getSPreference().edit()
            when (value) {
                is Int -> editor.putInt(key, value)
                is Boolean -> editor.putBoolean(key, value)
                is String -> editor.putString(key, value)
            }
            editor.apply()
        }

        @SuppressLint("CommitPrefEdits")
        fun deleteSPreference() {
            MyApplication
                    .application
                    .getSharedPreferences(fileName, 0)
                    .edit()
                    .remove(Constant.LOGIN)
                    .apply()
        }
    }
}