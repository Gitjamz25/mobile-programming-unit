package com.example.taskmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
    fun onLoginLinkClick(view: View) {
        // Start the registration activity or navigate to the registration screen
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}