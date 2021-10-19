package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)

        val intentButton = findViewById<Button>(R.id.intent_btn)
        intentButton.setOnClickListener {
            startActivity(
                    Intent(this, AnotherActivity::class.java)
                            .putExtra("data", "${editText1.text} ${editText2.text}"))
        }

        val sharedButton = findViewById<Button>(R.id.shared_btn)
        sharedButton.setOnClickListener {
            val sharePreferences = getSharedPreferences(getString(R.string.preference_file_key),
                    Context.MODE_PRIVATE)
            with(sharePreferences.edit()) {
                putString("data", "${editText1.text} ${editText2.text}")
                apply()
            }
            startActivity(Intent(this, AnotherActivity::class.java))
        }
    }
}