package com.example.midatingapp.view.composable.registerin


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.midatingapp.view.composable.registerin.unitcompose.BasicOutlineText
import com.example.midatingapp.view.composable.registerin.unitcompose.DatePickerTextField
import com.example.midatingapp.view.composable.registerin.unitcompose.ExistingAccount
import com.example.midatingapp.view.composable.registerin.unitcompose.Gander
import com.example.midatingapp.view.composable.registerin.unitcompose.OutletAttribute
import com.example.midatingapp.view.composable.registerin.unitcompose.RegisteringText
import com.example.midatingapp.view.composable.registerin.unitcompose.errorMessage
import com.example.midatingapp.view.composable.registerin.unitcompose.outletAttributeRegisPage2
import com.example.midatingapp.viewmodel.registering.RegisteringViewModel
import com.example.midatingapp.viewmodel.registering.User
import java.util.Date

// remember -> persist state of recomposition
// rememberSaveable -> persist state of recomposition even on config changes
@SuppressLint("SuspiciousIndentation")
@Composable
fun RegisteringC(
    registeringViewModel: RegisteringViewModel,
    outletAttribute: MutableList<OutletAttribute>,
    navController: NavHostController
) {
    val uservalue by registeringViewModel.user.observeAsState()
    val errorfield1 by registeringViewModel.errorField.observeAsState()
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF1C1B1B), Color(0xFFAA3FEC))
                )
            ),
        contentAlignment = Alignment.Center
    ) {


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

             NavHost(navController=navController, startDestination = "firstPage"){
                 composable("firstPage"){
                     firstPage(
                         registeringViewModel = registeringViewModel,
                         outletAttribute = outletAttribute,
                         uservalue = uservalue,
                         navController,
                     ) { registeringViewModel.checkErrorForFirstPage() }
                 }
                 composable("secondPage"){
                     secondPage(navController,uservalue, registeringViewModel = registeringViewModel)
                 }
             }

            errorMessage(errorfield1!!)
            ExistingAccount()
        }

    }

}



@Composable
fun firstPage(
    registeringViewModel: RegisteringViewModel,
    outletAttribute: MutableList<OutletAttribute>,
    uservalue: User?,
    navController: NavHostController,
    checkError: () -> Boolean,

    ) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RegisteringText(1)
        outletAttribute.forEach { outLet ->
            Log.i("my object", uservalue.toString())
            BasicOutlineText(
                textValue = when (outLet.text) {
                    "name" -> uservalue!!.name
                    "Email" -> uservalue!!.email
                    "password" -> uservalue!!.password
                    "confirm Password" -> uservalue!!.confirmedPassword
                    else -> ""
                },
                onValueChange = { newValue ->
                    when (outLet.text) {
                        "name" -> registeringViewModel.setName(name = newValue)
                        "Email" -> registeringViewModel.setEmail(email = newValue)
                        "password" -> registeringViewModel.setPassword(password = newValue)
                        "confirm Password" -> registeringViewModel.setConfirmedPassword(
                            confirmedPassword = newValue
                        )
                    }

                }, outletAttribute = outLet,
                isPassword = outLet.text == "password" || outLet.text == "confirm Password"
            )
        }
        ButtonCompose(onClick = {
            val secound = checkError()
            if (secound) {
                navController.navigate("secondPage")
            }

        })
    }

}

@Composable
fun secondPage(navController: NavHostController, uservalue: User?, registeringViewModel: RegisteringViewModel,) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RegisteringText(2)
        DatePickerTextField(Date(), mutableListOf<OutletAttribute>(outletAttributeRegisPage2[0])[0], value = uservalue!!,registeringViewModel)
        Gander(mutableListOf<OutletAttribute>(outletAttributeRegisPage2[0])[0])
        ButtonCompose({})

    }
}
@Composable
fun ButtonCompose(onClick: () -> Unit) {
    Button(
        onClick = onClick,
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



