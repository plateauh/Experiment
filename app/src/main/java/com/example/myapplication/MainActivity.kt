package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var buttons: List<Button>
    lateinit var editTexts: List<EditText>
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTexts = listOf (
                findViewById(R.id.some_et1),
                findViewById(R.id.some_et2),
                findViewById(R.id.some_et3))

        buttons = listOf (
                findViewById(R.id.toast_btn),
                findViewById(R.id.tv_btn),
                findViewById(R.id.activity_btn))

        textView = findViewById(R.id.some_tv)

        buttons[0].setOnClickListener {
            Toast.makeText(this, editTexts[0].text, Toast.LENGTH_SHORT).show()
        }

        buttons[1].setOnClickListener {
            textView.text = editTexts[1].text
        }

        buttons[2].setOnClickListener {
            val intent = Intent(this, AnotherActivity::class.java)
            intent.putExtra("data", editTexts[2].text.toString())
            startActivity(intent)
        }

    }

}