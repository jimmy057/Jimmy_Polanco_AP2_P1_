package com.example.jimmy_polanco_ap2_p1_

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jimmy_polanco_ap2_p1_.presentacion.navigation.AppNavGraph
import dagger.hilt.android.AndroidEntryPoint
import com.example.jimmy_polanco_ap2_p1_.ui.theme.Jimmy_Polanco_AP2_P1_Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Jimmy_Polanco_AP2_P1_Theme {
                AppNavGraph()
            }
        }
    }
}