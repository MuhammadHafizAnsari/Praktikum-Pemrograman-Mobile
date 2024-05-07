package com.example.twodiceroller

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceroll = dice.roll()
        val diceroll2 = dice.roll2()

        val diceImage1: ImageView = findViewById(R.id.dice_image1)
        val diceImage2: ImageView = findViewById(R.id.dice_image2)

        val drawableResource = when (diceroll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage1.setImageResource(drawableResource)

        val drawableResource2 = when (diceroll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)

        diceImage1.contentDescription = diceroll.toString()
        diceImage2.contentDescription = diceroll2.toString()

        if (diceroll == diceroll2) {
            showCustomToast("Selamat anda dapat dadu double!", Color.parseColor("#F0F0F0"), Color.BLACK)
        } else {
            showCustomToast("Anda belum beruntung!", Color.parseColor("#F0F0F0"), Color.BLACK)
        }
    }

    private fun showCustomToast(message: String, backgroundColor: Int, textColor: Int) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        val view = toast.view

        view?.background?.setColorFilter(backgroundColor, PorterDuff.Mode.SRC_IN)

        val text = view?.findViewById<TextView>(android.R.id.message)
        text?.setTextColor(textColor)

        toast.show()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return ((1..numSides).random())
    }

    fun roll2(): Int {
        return ((1..numSides).random())
    }
}