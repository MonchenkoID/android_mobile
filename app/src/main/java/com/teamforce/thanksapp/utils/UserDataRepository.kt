package com.teamforce.thanksapp.utils

import android.content.Context
import android.content.SharedPreferences

class UserDataRepository private constructor() {

    var token: String? = null
    var leastCoins: Int? = null
    var username: String? = null
    var tgId: String? = null

    fun saveCredentials(context: Context, authtoken: String?, telegram: String?) {
        savePreferences(context, authtoken, telegram)
    }

    fun logout(context: Context) {
        savePreferences(context, null, null)
    }

    private fun savePreferences(context: Context, authtoken: String?, telegram: String?) {
        val prefs: SharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putString(SP_ARG_TELEGRAM, telegram)
        editor.putString(SP_ARG_TOKEN, authtoken)
        editor.apply()
    }

    companion object {
        private const val SP_NAME = "com.teamforce.thanksapp"
        private const val SP_ARG_TELEGRAM = "Telegram"
        private const val SP_ARG_TOKEN = "Token"
        private var instance: UserDataRepository? = null

        fun getInstance(): UserDataRepository? {
            if (instance == null) {
                instance = UserDataRepository()
            }

            return instance
        }
    }
}
