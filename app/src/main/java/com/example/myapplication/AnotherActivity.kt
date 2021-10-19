package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AnotherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = intent.getStringExtra("data")

        val sharePreferences = getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE)
        val spButton = findViewById<Button>(R.id.sp_btn)
        spButton.setOnClickListener {
            textView.text = sharePreferences.getString("data", "")
        }
    }
}