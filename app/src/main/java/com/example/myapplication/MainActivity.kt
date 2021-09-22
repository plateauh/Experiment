package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

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

        btn.setOnClickListener{
            checkAll()
        }
    }

    fun checkAll(){
        checkPassword()
        checkRePassword()
        checkUsername()
    }

    fun checkUsername() {
        if (username.text.isEmpty()){
            message.text = "Please enter a username."
            return
        }

        if (username.text.contains(" ")) {
            message.text = "No spaces are allowed in username."
            return
        }

        if (username.text.length > 10) {
            message.text = "Please enter shorter username, 10 characters max."
            return
        }
    }

    fun checkPassword(){
        if (password.text.isEmpty()) {
            message.text = "Please enter a password."
            return
        }

        if (password.text.length < 8) {
            message.text = "The password is too short, please enter 8 or more characters."
            return
        }
    }

    fun checkRePassword(){
        if (rePassword.text.isEmpty()) {
            message.text = "Please re-enter the password."
            return
        }

        if (rePassword.text != password.text) {
            message.text = "The password & password re-entered don't match."
            Log.d("Password matching", "Password: ${password.text} | Repassword: ${rePassword.text} | Matching: ${password == rePassword}")
            return
        }
    }
}