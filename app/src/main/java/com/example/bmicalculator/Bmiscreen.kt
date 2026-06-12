package com.example.bmicalculator


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmicalculator.ui.theme.BMICalculatorTheme


@Composable
fun Bmiscreen(
    modifier: Modifier = Modifier
) {

    val bmiViewModel: BmiViewModel = viewModel()


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bmiViewModel.cardcolor.copy(alpha = 15f)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        // Main BMI Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(250.dp),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0x801E293B).copy(alpha = 0.6f)
            )

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Your BMI",
                        fontSize = 22.sp,
                        color = Color.White.copy(alpha = 0.3f),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = String.format("%.1f", bmiViewModel.bmi),
                        color = bmiViewModel.bmicolor,
                        fontSize = 64.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                } // Column End
            } // Box End
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(10.dp),
                shape = RoundedCornerShape(25.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0x801E293B)
                )


            )
            {

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = bmiViewModel.bmiCategory,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = bmiViewModel.bmicolor
                )
            }
        } // Main Card End

        Spacer(modifier = Modifier.height(4.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color(0x4D1E293B).copy(alpha = 0.7f)
            ),
            shape = RoundedCornerShape(25.dp),
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        "Weight (KG)",
                        modifier = Modifier.padding(10.dp),
                        fontWeight = FontWeight.Bold,
                        color = Color.White.copy(0.3f),
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        "${bmiViewModel.weight.toInt()}",
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Slider(
                    value = bmiViewModel.weight,
                    onValueChange = {
                        bmiViewModel.weight = it
                    },
                    valueRange = 20f..200f,
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFF10D9B8),
                        activeTrackColor = Color(0xFF10D9B8),
                        inactiveTrackColor = Color(0xFF1E293B)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

            }
        } // Result Card End

        Spacer(modifier = Modifier.height(4.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(180.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0x4D1E293B).copy(alpha = 0.7f)
            ),
            shape = RoundedCornerShape(25.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        "Height (CM)",
                        modifier = Modifier.padding(10.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White.copy(alpha = 0.3f)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        "${bmiViewModel.height.toInt()}",
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White


                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Slider(
                    value = bmiViewModel.height,
                    onValueChange = {
                        bmiViewModel.height = it
                    },
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFF10D9B8),
                        activeTrackColor = Color(0xFF10D9B8),
                        inactiveTrackColor = Color(0xFF1E293B)
                    ),
                    valueRange = 20f..230f
                )
            }
        } // Result Card End

        Spacer(modifier = Modifier.height(6.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0x4D1E293B)
            )

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        bmiViewModel.increase()
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(90.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF10D9B8)
                    )
                ) {
                    Text(
                        text = "Calculate BMI",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.padding(4.dp))
                Button(
                    onClick = {
                        bmiViewModel.reset()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0B2C52).copy(alpha = 0.6f)
                    ),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Text(
                        text = "Reset",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            } // Row end
        } // Result Card End
        Spacer(modifier = Modifier.height(5.dp))

    } // Main Column End
}

@Preview(showBackground = true)
@Composable
fun BmiscreenPreview() {
    BMICalculatorTheme {
        Bmiscreen()
    }
}
