package com.example.bmicalculator

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {

    var weight by mutableStateOf(60f)
    var height by mutableStateOf(100f)
    var bmi by mutableStateOf(0.0)
    var bmiCategory by mutableStateOf("")
    var bmicolor by mutableStateOf(Color(0xFF00BCD4))
    var showResult by mutableStateOf(false)
    var cardcolor by mutableStateOf(Color(0xFF020617))



    fun increase() {
        val w = weight.toDouble()
        val h = height.toDouble() / 100
        bmi = w / (h * h)

        showResult = true

        bmiCategory = when {
            bmi < 18.5 -> {
                bmicolor = Color(0xFF3B82F6)
                "Underweight, Eat More"
            }
            bmi < 25 -> {
                bmicolor = Color(0xFF00D4AA)
                "Normal weight"
            }
            bmi < 30 -> {
                bmicolor = Color(0xFFFF9800)
                "Overweight, Eat less"
            }
            else -> {
                bmicolor = Color(0xFFFF5252)
                "Obese, do exercise"
            }
        }
    }

    fun cardcolor(){

        bmicolor = Color.White
        cardcolor = Color.White
        bmiCategory = ""
        showResult = false

    }




    fun reset() {
        weight = 70f
        height = 170f
        bmi = 0.0
        bmiCategory = ""
        bmicolor = Color(0xFF19487E)
        showResult = false
    }
}
