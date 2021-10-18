package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var kotlinButton: Button
    lateinit var xmlButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kotlinButton = findViewById(R.id.ktln_btn)
        kotlinButton.setOnClickListener {
            Toast.makeText(this, "Coding", Toast.LENGTH_SHORT).show()
        }
        xmlButton = findViewById(R.id.xml_btn)
    }

    fun xmlButtonListener(view: View){
        Toast.makeText(this, "XML", Toast.LENGTH_SHORT).show()
    }
}