package com.example.midatingapp.view.composable.registerin


import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.midatingapp.view.composable.registerin.unitcompose.ExistingAccount
import com.example.midatingapp.view.composable.registerin.unitcompose.RegisteringText
import com.example.midatingapp.viewmodel.registering.RegisteringViewModel
import com.example.midatingapp.viewmodel.registering.User

// remember -> persist state of recomposition
// rememberSaveable -> persist state of recomposition even on config changes
@Composable
fun RegisteringC(registeringViewModel: RegisteringViewModel, stepByStep: Int = 1) {

    val uservalue = registeringViewModel.user.observeAsState(User("", "", ""))
    val password = registeringViewModel.password.observeAsState("")
    val secondPassword = registeringViewModel.secondPassword.observeAsState("")
    Log.i("my object", uservalue.value.toString())
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RegisteringText(stepByStep)

        nameOutlineText(name = uservalue.value.name, onNameChange = {
            registeringViewModel.setUser(name = it)
        })
        EmailOutlineText(email = uservalue.value.email, onNameChange = {
            registeringViewModel.setUser(email = it)
        })
        PasswordOutlineText(password = password.value, onNameChange = {
            registeringViewModel.setPassword1(password = it)
        })
        PasswordConfirmOutlineConfirmText(password = secondPassword.value, onNameChange = {
            registeringViewModel.setPassword2(it)
        })
        ButtonCompose()
        ExistingAccount()
    }

}


@Composable
fun nameOutlineText(name: String, onNameChange: (String) -> Unit) {
    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        label = { Text("Name") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White, // Change border color when focused
            cursorColor = Color.White, // Change cursor color
            textColor = Color.Black, // Change text color
            leadingIconColor = Color.Gray, // Change leading icon color
            trailingIconColor = Color.Gray, // Change trailing icon color
        )

    )
}

@Composable
fun EmailOutlineText(email: String, onNameChange: (String) -> Unit) {
    OutlinedTextField(value = email, onValueChange = onNameChange, label = { Text("Email") })
}

@Composable
fun PasswordOutlineText(password: String, onNameChange: (String) -> Unit) {

    OutlinedTextField(
        value = password,
        onValueChange = onNameChange,
        label = { Text("Password") },
//        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

        )
}

@Composable
fun PasswordConfirmOutlineConfirmText(password: String, onNameChange: (String) -> Unit) {

    OutlinedTextField(
        value = password,
        onValueChange = onNameChange,
        label = { Text("Password") },
        //visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

        )
}

@Composable
fun ButtonCompose() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(vertical = 50.dp)
            .width(300.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Text(text = "Next")
    }
}