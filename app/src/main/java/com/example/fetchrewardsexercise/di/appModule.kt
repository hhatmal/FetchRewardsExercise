package com.example.fetchrewardsexercise.di

import androidx.room.Room
import com.example.fetchrewardsexercise.FetchRewardsExerciseApp
import com.example.fetchrewardsexercise.data.network.RetrofitFactory
import com.example.fetchrewardsexercise.domain.RemoteUserDataSource
import com.example.fetchrewardsexercise.domain.LocalUserDataSource
import com.example.fetchrewardsexercise.data.RemoteUserDataSourceImpl
import com.example.fetchrewardsexercise.data.LocalUserDataSourceImpl
import com.example.fetchrewardsexercise.data.local.UserDatabase
import com.example.fetchrewardsexercise.data.OfflineFirstUserRepositoryImpl
import com.example.fetchrewardsexercise.domain.UserRepository
import com.example.fetchrewardsexercise.domain.UserDataValidator
import com.example.fetchrewardsexercise.presentation.overview.OverviewViewModel
import kotlinx.coroutines.CoroutineScope
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single<CoroutineScope> {
        (androidApplication() as FetchRewardsExerciseApp).applicationScope
    }
    single {
        OkHttpClient.Builder()
            .build()
    }
    single { RetrofitFactory(get()).build() }
    single { provideUserApi(get()) }
    single { get<UserDatabase>().userDao }
    singleOf(::RemoteUserDataSourceImpl).bind<RemoteUserDataSource>()
    singleOf(::LocalUserDataSourceImpl).bind<LocalUserDataSource>()
    single {
        Room.databaseBuilder(
            androidApplication(),
            UserDatabase::class.java,
            "user"
        ).fallbackToDestructiveMigration().build()
    }
    single { RemoteUserDataSourceImpl(get()) }
    single { LocalUserDataSourceImpl(get()) }
    singleOf(::OfflineFirstUserRepositoryImpl).bind<UserRepository>()
    singleOf(::UserDataValidator)
    viewModelOf(::OverviewViewModel)
}