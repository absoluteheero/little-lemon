package com.example.littlelemon.data

import android.content.Context

object UserSingleton{
    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null
    var isLoggedIn: Boolean = false

    // Save the user data to SharedPreferences
    fun saveToPreferences(context: Context) {
        val sharedPref = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("firstName", firstName)
            putString("lastName", lastName)
            putString("email", email)
            putBoolean("isLoggedIn", isLoggedIn)
            apply()
        }
    }

    // Load the user data from SharedPreferences
    fun loadFromPreferences(context: Context) {
        val sharedPref = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        firstName = sharedPref.getString("firstName", null)
        lastName = sharedPref.getString("lastName", null)
        email = sharedPref.getString("email", null)
        isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)
    }
}