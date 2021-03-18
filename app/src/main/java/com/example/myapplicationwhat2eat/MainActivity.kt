package com.example.myapplicationwhat2eat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val addBtn = findViewById<Button>(R.id.addBtn)
        val generateBtn = findViewById<Button>(R.id.generateBtn)
        val foodtextView = findViewById<TextView>(R.id.foodtextView)
        val foodimageView = findViewById<ImageView>(R.id.foodimageView)


        addBtn.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        generateBtn.setOnClickListener {
            val generateFood = Foodlist().getFood().random()
            generateFood.image
            generateFood.name
            foodtextView.text = generateFood.name + "!"

        }

    }
}
