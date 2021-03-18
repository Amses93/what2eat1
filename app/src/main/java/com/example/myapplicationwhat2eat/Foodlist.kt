package com.example.myapplicationwhat2eat

import android.media.Image

data class Food(val name: String, val image: String)


class Foodlist {

    fun getFood() : List<Food>{

        var foods = mutableListOf<Food>()

        var food1 = Food("Pizza", "pizza.png")
        foods.add(food1)

        var food2 = Food("Burrito", "burrito.png")
        foods.add(food2)

        return foods


    }

}