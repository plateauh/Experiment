package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.VISIBLE
import android.view.View.inflate
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            alert()
        }
    }

    private fun alert(){
        val dialogBuilder = AlertDialog.Builder(this)
        val dialogLayout = layoutInflater.inflate(R.layout.alert_layout, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.alert_et)
        val button = dialogLayout.findViewById<Button>(R.id.alert_btn)
        val textView = dialogLayout.findViewById<TextView>(R.id.alert_tv)
        dialogBuilder.setView(dialogLayout)
        button.setOnClickListener { textView.text = editText.text }
        dialogBuilder.setPositiveButton("Go") { _, _ ->
            startActivity(Intent(this, AnotherActivity::class.java).putExtra("data", editText.text.toString()))
        }
        val alert = dialogBuilder.create()
        alert.show()
    }
}