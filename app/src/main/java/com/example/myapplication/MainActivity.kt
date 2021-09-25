package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btn: Button
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var rePassword: EditText
    lateinit var message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.signupbtn)
        username = findViewById(R.id.username)
        password = findViewById(R.id.tePassword)
        rePassword = findViewById(R.id.teRePassword)
        message = findViewById(R.id.tvmsg)

        btn.setOnClickListener {
            if (usernameChecked() && passwordChecked() && rePasswordChecked())
                message.text = "You are good to go!"
        }
    }

    fun passwordChecked(): Boolean {

        when {
            password.text.isEmpty() -> {
                message.text = "Please enter a password."
                return false
            }
            password.text.length < 8 -> {
                message.text = "The password is too short, please enter 8 or more characters."
                return false
            }
            else -> return true
        }

    }

    fun rePasswordChecked(): Boolean {

        when {
            rePassword.text.isEmpty() -> {
                message.text = "Please re-enter the password."
                return false
            }
            rePassword.text.toString() != password.text.toString() -> {
                message.text = "The password & password re-entered don't match."
                Log.d("Password matching", "Password: ${password.text} | Repassword: ${rePassword.text} | Matching: ${password.text.toString() == rePassword.text.toString()}")
                return false
            }
            else -> return true
        }

    }

    fun usernameChecked(): Boolean {

        when {
            username.text.isEmpty() -> {
                message.text = "Please enter a username."
                return false
            }
            username.text.contains(" ") -> {
                message.text = "No spaces are allowed in username."
                return false
            }
            username.text.length > 10 -> {
                message.text = "Please enter shorter username, 10 characters max."
                return false
            }
            username.text[0].isDigit() -> {
                message.text = "Username mustn't starts with a digit"
                return false
            }
            else -> return true
        }

    }
}