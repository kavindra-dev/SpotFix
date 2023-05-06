package com.kavi.spotfix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.kavi.spotfix.ui.home.HomeScreen
import com.kavi.spotfix.ui.ui.theme.SpotfixTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContent {

            SpotfixTheme {
                Surface(

                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    color = MaterialTheme.colors.background

                ) {
                    HomeScreen()
                }

            }

        }
    }
}


