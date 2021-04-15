package com.example.whattoeat

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter() : RecyclerView.Adapter<MainViewHolder>() {


    lateinit var parentact : SecondActivity

    var selectedFoods = mutableSetOf<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val vh = MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_recyclerview, parent, false))
        return vh
    }

    override fun getItemCount(): Int {
        return Foodlist().getFood().size
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentFood = Foodlist().getFood()[position]

        if(selectedFoods.contains(currentFood.name))
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#c4f0ae"))
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"))
        }

        holder.itemView.setOnClickListener {
            if(selectedFoods.contains(currentFood.name))
            {
                selectedFoods.remove(currentFood.name)
            } else {
                selectedFoods.add(currentFood.name)
            }

            notifyItemChanged(position)

            // SPARA TILL SHARED PREF
            val sharedpref = parentact.getSharedPreferences("whateat", Context.MODE_PRIVATE)
            with(sharedpref.edit()) {
                clear()
                putStringSet("selectedfood", selectedFoods)
                commit()
            }


            Log.d("fooddebug", selectedFoods.toString())
        }
        holder.txtView.text = currentFood.name
        //holder.foodPics = currentFood.image

        var imagename = currentFood.name.toLowerCase()
        var imgResource = parentact.resources.getIdentifier(imagename, "drawable", parentact.packageName)

        holder.foodPics.setImageResource(imgResource)
    }

}

class MainViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var txtView = view.findViewById<TextView>(R.id.rvTxtview)
    var foodPics = view.findViewById<ImageView>(R.id.foodpicImgView)

}



