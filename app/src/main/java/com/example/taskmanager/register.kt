package com.example.taskmanager

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registration.database.RegistrationDatabaseHelper
import com.example.registration.model.RegistrationData



class RegisterActivity : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var departmentEditText: EditText
    private lateinit var registerButton: Button

    private lateinit var registrationDatabaseHelper: RegistrationDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize views
        firstNameEditText = findViewById(R.id.editTextText2)
        lastNameEditText = findViewById(R.id.editTextText5)
        genderRadioGroup = findViewById(R.id.radioGroup)
        departmentEditText = findViewById(R.id.editTextText4)
        registerButton = findViewById(R.id.button2)

        // Initialize database helper
        registrationDatabaseHelper = RegistrationDatabaseHelper(this)

        // Set click listener for the register button
        registerButton.setOnClickListener { register() }
    }

    private fun register() {
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()

        val selectedGenderId = genderRadioGroup.checkedRadioButtonId
        val gender = when (selectedGenderId) {
            R.id.radioButton -> "Female"
            R.id.radioButton2 -> "Male"
            else -> ""
        }

        val department = departmentEditText.text.toString()

        if (firstName.isNotEmpty() && lastName.isNotEmpty() && gender.isNotEmpty() && department.isNotEmpty()) {
            val registrationData = RegistrationData(firstName, lastName, gender, department)
            registrationDatabaseHelper.insertRegistrationData(registrationData)

            // You can add additional logic here, such as navigating to another activity or showing a success message
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
        } else {
            // Handle empty fields
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
        }
    }

    // You can also implement other methods as needed, such as reading or updating data.
}
