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

        var food3 = Food("Burger", "burger.png")
        foods.add(food3)

        var food4 = Food("Hotdog", "hotdog.png")
        foods.add(food4)

        var food5 = Food("Salad", "salad.png")
        foods.add(food5)

        var food6 = Food("Steak", "steak.png")
        foods.add(food6)

        var food7 = Food("Sushi", "sushi.png")
        foods.add(food7)

        var food8 = Food("Tacos", "tacos.png")
        foods.add(food8)

        var food9 = Food ("Chicken", "chicken.png")
        foods.add(food9)

        var food10 = Food ("Kebab", "kebab.png")
        foods.add(food10)

        var food11 = Food("Lasagna", "lasagna.png")
        foods.add(food11)

        var food12 = Food("Pancakes",  "pancakes.png")
        foods.add(food12)

        var food13 = Food("Pie", "pie.png")
        foods.add(food13)

        var food14 = Food("Sandwich", "sandwich.png")
        foods.add(food14)

        var food15 = Food("Seafood", "seafood.png")
        foods.add(food15)

        var food16 = Food("Soup","soup.png")
        foods.add(food16)

        var food17 = Food("Pasta", "pasta.png")
        foods.add(food17)

        var food18 = Food("Stew", "stew.png")
        foods.add(food18)

        return foods


    }

}