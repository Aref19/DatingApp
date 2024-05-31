package com.example.midatingapp.view.composable.registerin.unitcompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midatingapp.view.ui.theme.RegisteringTexts


@Composable
fun RegisteringText(stepByStep: Int) {
    var twoCycle: Boolean = stepByStep == 2 || stepByStep == 3
    val thirdCycle = stepByStep == 3
    Text(
        fontSize = 20.sp,
        text = RegisteringTexts.title
    )
    Text(
        text = RegisteringTexts.subTitle,
        modifier = Modifier.padding(16.dp)
    )

    Row(
    ) {
        Circle(true)
        Spacer(modifier = Modifier.width(30.dp))
        Circle(twoCycle)
        Spacer(modifier = Modifier.width(30.dp))
        Circle(thirdCycle)


    }
}

@Composable
fun Circle(fullCycle: Boolean) {
    if (fullCycle) {
        Canvas(modifier = Modifier.size(16.dp)) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.width / 4 // Adjust the radius as needed

            drawCircle(
                color = Color.White,  // Change color as needed
                center = center,
                radius = radius  // Change stroke width as needed
            )
        }
    } else {
        Canvas(modifier = Modifier.size(16.dp)) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.width / 4 // Adjust the radius as needed

            drawCircle(
                color = Color.White,  // Change color as needed
                center = center,
                radius = radius,
                style = Stroke(width = 2f)  // Change stroke width as needed
            )
        }
    }
}

@Composable
fun ExistingAccount() {
    Row(modifier = Modifier.padding(vertical = 20.dp)) {
        Text(text = "Existing account?")
        Text(text = "LogIn")
    }
}

@Composable
fun BasicOutlineText(
    onValueChange: (String) -> Unit,
    outletAttribute: OutletAttribute,
    textValue: String

) {
    OutlinedTextField(
        value =textValue,
        onValueChange = onValueChange,
        label = { Text(outletAttribute.text) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = outletAttribute.textFieldColors.focusedBorderColor, // Change border color when focused
            cursorColor = outletAttribute.textFieldColors.cursorColor, // Change cursor color
            textColor = outletAttribute.textFieldColors.textColor, // Change text color
        )
//        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

    )
}

data class OutletAttribute(
    val text: String,

    val textFieldColors: OutLineTextColor
)

data class OutLineTextColor(
    val focusedBorderColor: Color,
    val cursorColor: Color,
    val textColor: Color,
    val errorBorderColor: Color,
)

// first Page

var outletAttribute = mutableListOf(
    OutletAttribute(
        text = "name",

        OutLineTextColor(
            focusedBorderColor = Color.White, // Change border color when focused
            cursorColor = Color.White, // Change cursor color
            textColor = Color.Black, // Change text color
            errorBorderColor = Color.Red,
        )
    ),
    OutletAttribute(
        text = "Email",

        OutLineTextColor(
            focusedBorderColor = Color.White, // Change border color when focused
            cursorColor = Color.White, // Change cursor color
            textColor = Color.Black, // Change text color
            errorBorderColor = Color.Red,
        )
    ),

    OutletAttribute(
        text = "password",

        OutLineTextColor(
            focusedBorderColor = Color.White, // Change border color when focused
            cursorColor = Color.White, // Change cursor color
            textColor = Color.Black, // Change text color
            errorBorderColor = Color.Red,
        )
    ),

    OutletAttribute(
        text = "confirm Password",
        OutLineTextColor(
            focusedBorderColor = Color.White, // Change border color when focused
            cursorColor = Color.White, // Change cursor color
            textColor = Color.Black, // Change text color
            errorBorderColor = Color.Red,
        )
    ),


    )