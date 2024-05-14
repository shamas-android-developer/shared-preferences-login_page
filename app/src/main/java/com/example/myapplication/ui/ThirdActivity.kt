package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.data.Constant
import com.example.myapplication.data.SharedPref

class ThirdActivity : AppCompatActivity() {

    private lateinit var loginPref : SharedPref
    private lateinit var viewableUserName : TextView
    private lateinit var username : TextView
    private lateinit var viewablePassword : TextView
    private lateinit var password :TextView
    private lateinit var buttonBack: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // Initialize view elements
        viewableUserName = findViewById(R.id.textViewUsernameLabel)
        username = findViewById(R.id.textUsername)
        viewablePassword = findViewById(R.id.textViewPasswordLabel)
        password = findViewById(R.id.textPassword)
        buttonBack = findViewById(R.id.back_button)

        loginPref = SharedPref(this)

        username.text = loginPref.getString( Constant.PREF_USERNAME)
        password.text = loginPref.getString(Constant.PREF_PASSWORD)

        buttonBack.setOnClickListener{
            moveIntent()
        }

    }

    private fun moveIntent(){
        startActivity(Intent(this, SecondActivity::class.java))
        finish()
    }


}