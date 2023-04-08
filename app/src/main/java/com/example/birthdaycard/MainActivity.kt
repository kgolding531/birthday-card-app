package com.example.birthdaycard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val dateOfBirthMonth = findViewById<EditText>(R.id.editTextMonth)
        val dateOfBirthDay = findViewById<EditText>(R.id.editTextDay)
        val dateOfBirthYear = findViewById<EditText>(R.id.editTextYear)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {

            // Get the input values from the EditText fields
            val name = nameEditText.text.toString()
            val month = dateOfBirthMonth.text.toString()
            val day = dateOfBirthDay.text.toString()
            val year = dateOfBirthYear.text.toString()

            // Validate the name input
            if (name.isEmpty()) {
                nameEditText.error = "Please enter a name"
                return@setOnClickListener
            }

            // Validate date of birth input with this code
            if (!isValidDate(month, day, year)) {
                dateOfBirthMonth.error = "Please enter a valid date"
                dateOfBirthDay.error = "Please enter a valid date"
                dateOfBirthYear.error = "Please enter a valid date"
                return@setOnClickListener
            }

            // If input is correct, begin the next activity now
            val intent = Intent(this, BirthdayCardDisplay::class.java)
            intent.putExtra("Name", name)
            intent.putExtra("Month", month)
            intent.putExtra("Day", day)
            intent.putExtra("Year", year)
            startActivity(intent)
        }
    }

    // METHOD DEFINITION
    private fun isValidDate(month: String, day: String, year: String): Boolean {
        val calendar = Calendar.getInstance()
        calendar.setLenient(false)
        try {
            calendar.set(Calendar.MONTH, month.toInt() - 1)
            calendar.set(Calendar.DAY_OF_MONTH, day.toInt())
            calendar.set(Calendar.YEAR, year.toInt())
            calendar.timeInMillis
        } catch (e: Exception) {
            return false
        }
        return true
    }
}
