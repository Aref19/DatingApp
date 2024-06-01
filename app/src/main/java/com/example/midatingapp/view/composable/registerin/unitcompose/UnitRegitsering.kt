package com.example.midatingapp.view.composable.registerin.unitcompose

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midatingapp.R
import com.example.midatingapp.view.ui.theme.RegisteringImageText
import com.example.midatingapp.view.ui.theme.RegisteringTexts
import com.example.midatingapp.viewmodel.registering.Error
import java.util.Date


@Composable
fun RegisteringText(stepByStep: Int) {
    var twoCycle: Boolean = stepByStep == 2 || stepByStep == 3
    val thirdCycle = stepByStep == 3
    Text(
        fontSize = 20.sp,
        text = RegisteringTexts.title,
        color = Color.White
    )
    Text(
        text = RegisteringTexts.subTitle,
        modifier = Modifier.padding(16.dp),
        color = Color.White
    )

    Row(
    ) {
        Circle(true)
        Spacer(modifier = Modifier.width(30.dp))
        Circle(twoCycle)
        Spacer(modifier = Modifier.width(30.dp))
        Circle(thirdCycle)
    }

    if (stepByStep == 2) {

        ImageSelect()
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
        Text(text = "Existing account?", color = Color.White)
        Text(text = "LogIn", color = Color.White)
    }
}

@Composable
fun errorMessage(messages: MutableList<Error>) {
    if (messages.isNotEmpty()) {
        Text(
            text = "please check your " + messages[0].errorType,
            color = Color.Red,
        )
    }

}

@Composable
fun ImageSelect() {
    val painter =
        painterResource(id = R.drawable.baseline_person_add_alt_24) // Replace R.drawable.your_image with your image resource
    Text(
        text = RegisteringImageText.subTitle,
        modifier = Modifier.padding(16.dp),
        color = Color.White
    )
    Image(
        painter = painter,
        contentDescription = "Image",
        modifier = Modifier.size(80.dp),

        )

}

@Composable
fun BasicOutlineText(
    onValueChange: (String) -> Unit,
    outletAttribute: OutletAttribute,
    textValue: String,
    isPassword: Boolean = false

) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = textValue,
        onValueChange = onValueChange,
        label = { Text(outletAttribute.text, color = Color.White) },
        trailingIcon = {
            if (isPassword) {
                val image =
                    if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = null)
                }
            }
        },
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = outletAttribute.textFieldColors.focusedBorderColor, // Change border color when focused
            cursorColor = outletAttribute.textFieldColors.cursorColor, // Change cursor color
            textColor = outletAttribute.textFieldColors.textColor, // Change text color
            unfocusedBorderColor = Color.White,
        )
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
    val textStyle: Color
)

// first Page

var outletAttributeRegisPage1 = mutableListOf(
    OutletAttribute(
        text = "name",
        OutLineTextColor(
            focusedBorderColor = Color.White, // Change border color when focused
            cursorColor = Color.White, // Change cursor color
            textColor = Color.Black, // Change text color
            errorBorderColor = Color.Red,
            textStyle = Color.White

        )
    ),
    OutletAttribute(
        text = "Email",

        OutLineTextColor(
            focusedBorderColor = Color.White, // Change border color when focused
            cursorColor = Color.White, // Change cursor color
            textColor = Color.Black, // Change text color
            errorBorderColor = Color.Red,
            textStyle = Color.White
        )
    ),

    OutletAttribute(
        text = "password",

        OutLineTextColor(
            focusedBorderColor = Color.White, // Change border color when focused
            cursorColor = Color.White, // Change cursor color
            textColor = Color.Black, // Change text color
            errorBorderColor = Color.Red,
            textStyle = Color.White
        )
    ),

    OutletAttribute(
        text = "confirm Password",
        OutLineTextColor(
            focusedBorderColor = Color.White, // Change border color when focused
            cursorColor = Color.White, // Change cursor color
            textColor = Color.Black, // Change text color
            errorBorderColor = Color.Red,
            textStyle = Color.White
        )
    ),


    )
var outletAttributeRegisPage2 = mutableListOf(
    OutletAttribute(
        text = "your Breath",
        OutLineTextColor(
            focusedBorderColor = Color.White, // Change border color when focused
            cursorColor = Color.White, // Change cursor color
            textColor = Color.Black, // Change text color
            errorBorderColor = Color.Red,
            textStyle = Color.White

        )
    ),
    OutletAttribute(
        text = "Gender",
        OutLineTextColor(
            focusedBorderColor = Color.White, // Change border color when focused
            cursorColor = Color.White, // Change cursor color
            textColor = Color.Black, // Change text color
            errorBorderColor = Color.Red,
            textStyle = Color.White
        )
    ),
)


@Composable
fun DatePickerTextField(
    selectedDate: Date?,
    outletAttribute: OutletAttribute,
) {
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    OutlinedTextField(
        value = selectedDate?.let { it }.toString() ?: "",
        onValueChange = { /* Ignoring manual input for now */ },
        label = { Text("Date", color = Color.White) },
        readOnly = true, // Prevents manual input
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                showDialog = true
            }
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.CalendarToday,
                contentDescription = null,
                modifier = Modifier.clickable { showDialog = true }
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = outletAttribute.textFieldColors.focusedBorderColor, // Change border color when focused
            cursorColor = outletAttribute.textFieldColors.cursorColor, // Change cursor color
            textColor = outletAttribute.textFieldColors.textColor, // Change text color
            unfocusedBorderColor = Color.White,

            )
    )
    if (showDialog) {
        DatePickerDialogCo(selectedDate)
    }

}

@Composable
fun Gander(

    outletAttribute: OutletAttribute,
) {
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    OutlinedTextField(
        value = "",
        onValueChange = { /* Ignoring manual input for now */ },
        label = { Text("Your Gander", color = Color.White) },
        readOnly = true, // Prevents manual input
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                showDialog = true
            }
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier.clickable { showDialog = true }
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = outletAttribute.textFieldColors.focusedBorderColor, // Change border color when focused
            cursorColor = outletAttribute.textFieldColors.cursorColor, // Change cursor color
            textColor = outletAttribute.textFieldColors.textColor, // Change text color
            unfocusedBorderColor = Color.White,

            )
    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogCo(selectedDate: Date?) {
    val datePickerState = rememberDatePickerState(
        initialDisplayedMonthMillis = System.currentTimeMillis(),
        yearRange = 1900..2024
    )
    val showDatePicker = remember { mutableStateOf(true) }
    var selected=remember { mutableStateOf(selectedDate) }
    if (showDatePicker.value) {
        DatePickerDialog(

            onDismissRequest = { },
            confirmButton = {
                TextButton(
                    onClick = { showDatePicker.value = false },
                    enabled = datePickerState.selectedDateMillis != null
                ) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker.value = false }) {
                    Text(text = "Dismiss")
                }
            }) {
            selected.value= Date(datePickerState.selectedDateMillis!!)
            DatePicker(
                state = datePickerState
            )

        }
    }
}

enum class UserGander {
    Male,
    Female
}