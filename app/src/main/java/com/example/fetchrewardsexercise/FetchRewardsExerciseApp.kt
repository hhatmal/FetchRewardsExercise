package com.example.fetchrewardsexercise

import android.app.Application
import com.example.fetchrewardsexercise.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class FetchRewardsExerciseApp: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FetchRewardsExerciseApp)
            modules(
                appModule
            )
        }
    }
}