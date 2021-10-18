package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intent = Intent(this, MainActivity::class.java) // im forced on this haha
        when (item.itemId){
            R.id.home_item -> intent = Intent(this, HomeActivity::class.java)
            R.id.about_item -> intent = Intent(this, AboutActivity::class.java)
            R.id.help_item -> intent = Intent(this, HelpActivity::class.java)
        }
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}