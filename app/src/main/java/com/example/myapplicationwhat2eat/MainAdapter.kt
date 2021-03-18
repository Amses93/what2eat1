package com.example.myapplicationwhat2eat

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter() : RecyclerView.Adapter<MainViewHolder>() {

    var foodname = mutableListOf<String>("remind:me", "lär dig alfabetet", "Kommer snart", "Kommer snart",
            "kommer snart","remind:me", "lär dig alfabetet", "Kommer snart", "Kommer snart")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val vh = MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_recyclerview, parent, false))
        return vh
    }

    override fun getItemCount(): Int {
        return Foodlist().getFood().size
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentFood = Foodlist().getFood()[position]
        holder.txtView.text = currentFood.name
       // holder.foodPics = currentFood.image
    }

}

class MainViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var txtView = view.findViewById<TextView>(R.id.rvTxtview)
    var foodPics = view.findViewById<ImageView>(R.id.foodpicImgView)

}






