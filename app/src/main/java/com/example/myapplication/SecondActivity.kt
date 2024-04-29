
package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.helper.SharedPref

class SecondActivity : AppCompatActivity() {

    private lateinit var welcomeScreen: SharedPref
    private lateinit var multilineText: EditText
    private lateinit var buttonLogout: Button
    private lateinit var buttonLogInfo: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Initialize view elements
        buttonLogout = findViewById(R.id.buttonLogout)
        buttonLogInfo = findViewById(R.id.buttonLoginInfo)
        multilineText = findViewById(R.id.editMultiLine)

        welcomeScreen = SharedPref(this)

        buttonLogInfo.setOnClickListener {
            moveToIntent()

        }
        buttonLogout.setOnClickListener {
            welcomeScreen.clear()
            showMessage("Preferences cleared..")
            moveIntent()
        }
    }

    private fun moveToIntent() {
        startActivity(Intent(this, ThirdActivity::class.java))
    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}