package com.example.midatingapp.view.composable.registerin


import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.midatingapp.view.composable.registerin.unitcompose.BasicOutlineText
import com.example.midatingapp.view.composable.registerin.unitcompose.ExistingAccount
import com.example.midatingapp.view.composable.registerin.unitcompose.OutletAttribute
import com.example.midatingapp.view.composable.registerin.unitcompose.RegisteringText
import com.example.midatingapp.viewmodel.registering.RegisteringViewModel
import com.example.midatingapp.viewmodel.registering.User

// remember -> persist state of recomposition
// rememberSaveable -> persist state of recomposition even on config changes
@Composable
fun RegisteringC(
    registeringViewModel: RegisteringViewModel,
    stepByStep: Int = 1,
    outletAttribute: MutableList<OutletAttribute>
) {
    val uservalue = registeringViewModel.user.observeAsState(User("", "", "",""))


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RegisteringText(stepByStep)
        outletAttribute.forEach { outLet ->
            Log.i("my object", uservalue.value.toString())
            BasicOutlineText(
                textValue = when (outLet.text) {
                    "name" -> uservalue.value.name
                    "Email" -> uservalue.value.email
                    "password" -> uservalue.value.password
                    "confirm Password"-> uservalue.value.conforimedPassword
                    else -> ""
                },
                onValueChange = {newValue->
                    when (outLet.text) {
                        "name" -> registeringViewModel.setUser( name = newValue)
                        "Email"-> registeringViewModel.setUser(email =  newValue)
                        "password"-> registeringViewModel.setUser(password= newValue)
                        "confirm Password"-> registeringViewModel.setUser(conforimedPassword = newValue)
                    }

                }, outletAttribute = outLet
            )
        }
        ButtonCompose()
        ExistingAccount()
    }

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