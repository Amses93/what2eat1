package com.example.myapplicationwhat2eat

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity() {
    internal lateinit var addfoodBtn : Button
    internal lateinit var myDialog : Dialog
    internal lateinit var dismisspopupBtn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        val addfoodBtn =findViewById<FloatingActionButton>(R.id.addfoodBtn)
        //val dismisspopupBtn = findViewById<ImageButton>(R.id.dismisspopupBtn)


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





        //backspace top left corner
        /*val actionbar = supportActionBar

        actionbar!!.title = "Second Activity"

        actionbar.setDisplayHomeAsUpEnabled(true)
*/





    }
}


