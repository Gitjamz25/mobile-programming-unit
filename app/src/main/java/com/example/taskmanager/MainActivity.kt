package com.example.taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onRegisterLinkClick(view: View) {
        // Start the registration activity or navigate to the registration screen
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}