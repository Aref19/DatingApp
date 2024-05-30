package com.example.midatingapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.example.midatingapp.view.composable.registerin.RegisteringC
import com.example.midatingapp.view.ui.theme.Lila
import com.example.midatingapp.view.ui.theme.MIDatingAppTheme
import com.example.midatingapp.viewmodel.registering.RegisteringViewModel

class RegisteringActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModule = ViewModelProvider(this)[RegisteringViewModel::class.java]
        setContent {
            MIDatingAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Lila
                ) {
                    RegisteringC(viewModule, stepByStep = 1)
                }
            }
        }
    }


}