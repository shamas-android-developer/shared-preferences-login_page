package com.example.myapplication.helper

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedPref(context: Context) {

    private val PREFs_NAME = "shared-preferences"
    private var appSharedPreference: SharedPreferences = context.getSharedPreferences(PREFs_NAME, MODE_PRIVATE)
    val editor = appSharedPreference.edit()


    fun put(key: String, value: String) {

        editor.putString(key, value).apply()
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key, value)
            .apply()
    }

    fun getBoolean(key: String): Boolean {
        return appSharedPreference.getBoolean(key, false)
    }

    fun getString(key: String): String? {
        return appSharedPreference.getString(key, null)
    }

    fun clear() {
        editor.clear()
            .apply()
    }

}