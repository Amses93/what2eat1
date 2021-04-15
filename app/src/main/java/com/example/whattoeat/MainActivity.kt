package com.example.whattoeat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import android.media.MediaPlayer

class MainActivity : AppCompatActivity() {

    var selectedFoods = mutableSetOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBtn = findViewById<Button>(R.id.addBtn)
        val generateBtn = findViewById<Button>(R.id.generateBtn)
        val foodtextView = findViewById<TextView>(R.id.foodtextView)
        val foodimageView = findViewById<ImageView>(R.id.foodimageView)
        val firsText = findViewById<TextView>(R.id.foodtextView2)
        val resetBtn = findViewById<Button>(R.id.resetBtn)


        var generatebtnsound = MediaPlayer.create(this, R.raw.generatesound)



        addBtn.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        resetBtn.isVisible = false

        resetBtn.setOnClickListener {
            val intent = intent
            finish()
            overridePendingTransition( 0, 0)
            startActivity(getIntent())
            overridePendingTransition( 0, 0)

        }


        generateBtn.setOnClickListener {

            if(selectedFoods.size == 0)
            {
                firsText.text = "No food added!"
                return@setOnClickListener
            }

            val randomFood = selectedFoods.random()
            val generateFood = Foodlist().getFood().random()

            foodtextView.text = randomFood + "!"


            var imagename = randomFood.toLowerCase()
            var imgResource = resources.getIdentifier(imagename, "drawable", packageName)

            foodimageView.setImageResource(imgResource)

            generatebtnsound.start()

            firsText.isVisible = false
            generateBtn.isVisible = false
            resetBtn.isVisible = true


        }


    }

    override fun onStart() {
        super.onStart()

        val sharedpref = getSharedPreferences("whateat", Context.MODE_PRIVATE)
        sharedpref.getStringSet("selectedfood", null)?.let { savedselected ->
            selectedFoods = savedselected
        }

    }
}