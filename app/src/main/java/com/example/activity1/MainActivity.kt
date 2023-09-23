package com.example.activity1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var register: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.emailAddEditText)
        password = findViewById(R.id.passwordEditText)
        confirmPassword = findViewById(R.id.confirmPassEditText)
        register = findViewById(R.id.registerButton)

        register.setOnClickListener {
            if (password.text.toString().isEmpty() || confirmPassword.text.toString().isEmpty() || email.text.toString().isEmpty())
            {
                Toast.makeText(this, "Some fields are empty!", Toast.LENGTH_LONG).show()
            }

            else
            {
                if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches())
                {
                    Toast.makeText(this, "Email is invalid!", Toast.LENGTH_LONG).show()
                }

                else if (password.text.toString().equals(confirmPassword.text.toString(), ignoreCase = false))
                {
                    Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_LONG).show()
                }

                else
                {
                    Toast.makeText(this, "Password do not match!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}