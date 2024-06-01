package com.example.midatingapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.midatingapp.view.composable.registerin.RegisteringC
import com.example.midatingapp.view.composable.registerin.unitcompose.outletAttributeRegisPage1
import com.example.midatingapp.viewmodel.registering.RegisteringViewModel

class RegisteringActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModule = ViewModelProvider(this)[RegisteringViewModel::class.java]

        setContent {
            val navController = rememberNavController()
            RegisteringC(
                viewModule,
                outletAttributeRegisPage1,
                navController
            )


        }


    }


}