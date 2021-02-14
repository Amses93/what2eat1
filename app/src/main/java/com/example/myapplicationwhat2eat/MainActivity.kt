package com.example.myapplicationwhat2eat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val addBtn = findViewById<Button>(R.id.addBtn)


        addBtn.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

        }


    }
}
