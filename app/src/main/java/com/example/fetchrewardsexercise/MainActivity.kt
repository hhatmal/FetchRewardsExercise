package com.example.fetchrewardsexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.fetchrewardsexercise.presentation.designsystem.FetchRewardsExerciseTheme
import com.example.fetchrewardsexercise.presentation.overview.OverviewScreenRoot
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchRewardsExerciseTheme {
                KoinContext {
                    OverviewScreenRoot()
                }
            }
        }
    }
}