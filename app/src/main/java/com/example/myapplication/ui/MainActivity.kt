package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.data.Constant
import com.example.myapplication.data.SharedPref

class MainActivity : AppCompatActivity() {

    private lateinit var thisPref: SharedPref
    private lateinit var editUsername: EditText
    private lateinit var editPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize view elements
        editUsername = findViewById(R.id.editUsername)
        editPassword = findViewById(R.id.editPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        thisPref = SharedPref(this)

        buttonLogin.setOnClickListener{

            if (editUsername.text.isNotEmpty() && editPassword.text.isNotEmpty()) {

                saveSession(editUsername.text.toString(), editPassword.text.toString())
                showMessage("User logged in successfully")
                moveIntent()

            }

        }


    }

    override fun onStart() {
        super.onStart()
        if (thisPref.getBoolean(Constant.PREF_IS_LOGIN)) {
            moveIntent()
        }
    }

    private fun saveSession(username: String, password: String) {


        thisPref.put(Constant.PREF_USERNAME, username)
        thisPref.put(Constant.PREF_PASSWORD, password)
        thisPref.put(Constant.PREF_IS_LOGIN, true)
    }

    private fun moveIntent() {
        startActivity(Intent(this, SecondActivity::class.java))
        finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
            .show()
    }

}