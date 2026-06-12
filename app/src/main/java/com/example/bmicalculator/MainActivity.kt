package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.activity.enableEdgeToEdge
import com.example.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge( )
        setContent {
            BMICalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),


                    ) { innerPadding ->
                    Bmiscreen( modifier = Modifier.padding(innerPadding))
                }
            }
        }

}}
