package com.example.midatingapp.view


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import com.example.midatingapp.view.ui.theme.Lila

import com.example.midatingapp.view.ui.theme.MIDatingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,RegisteringActivity::class.java))
        setContent {
            MIDatingAppTheme {
                // A surface container using the 'background' color from the theme

        }
    }
}
}

