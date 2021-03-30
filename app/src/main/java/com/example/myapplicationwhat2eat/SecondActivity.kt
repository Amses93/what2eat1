package com.example.myapplicationwhat2eat

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity() {


    var Adapter = MyAdapter()

    internal lateinit var addfoodBtn : Button
    internal lateinit var myDialog : Dialog
    internal lateinit var dismisspopupBtn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        var doneBtn = findViewById<Button>(R.id.doneBtn)

        Adapter.parentact = this

        val sharedpref = getSharedPreferences("whateat", Context.MODE_PRIVATE)
        sharedpref.getStringSet("selectedfood", null)?.let { savedselected ->
            Adapter.selectedFoods = savedselected
            Log.d("fooddebug", savedselected.toString())
        }

        var tableview = findViewById<RecyclerView>(R.id.foodlistRecyclerview)
        tableview.layoutManager = LinearLayoutManager(this)
        tableview.adapter = Adapter


        val addfoodBtn =findViewById<FloatingActionButton>(R.id.addfoodBtn)
        //val dismisspopupBtn = findViewById<ImageButton>(R.id.dismisspopupBtn)
            addfoodBtn.isVisible = false

        fun showDialog() {
            myDialog = Dialog(this)
            myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            myDialog.setContentView(R.layout.foodpopup)
            myDialog.setTitle("FOOD")

            dismisspopupBtn = myDialog.findViewById(R.id.dismisspopupBtn) as ImageButton
            dismisspopupBtn.isEnabled = true
            dismisspopupBtn.setOnClickListener {
                myDialog.cancel()
            }

            myDialog.show()

        }

        addfoodBtn.setOnClickListener {
           showDialog()

        }


        doneBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


        //backspace top left corner
      /*  val actionbar = supportActionBar

        actionbar!!.title = "Second Activity"

        actionbar.setDisplayHomeAsUpEnabled(true)

*/




    }

}


