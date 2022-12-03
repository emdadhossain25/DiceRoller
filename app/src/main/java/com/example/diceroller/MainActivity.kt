package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Random
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // binding object of activity_main.xml file
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inflating activity_main.xml file in the form of view binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        getString(R.string.let_roll).also { letsRoll -> binding.rollButton.text = letsRoll }
        binding.rollButton.setOnClickListener {
            rolldice()
        }

        //hierarchy of the view in this case (linearlayout-> button+text) is represented by root of the binding class
        val view = binding.root
        setContentView(view)
    }

    private fun rolldice() {
        val randomInt = Random().nextInt(6) + 1
        val resourceDrawable= when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImage.setImageResource(resourceDrawable)
    }
}