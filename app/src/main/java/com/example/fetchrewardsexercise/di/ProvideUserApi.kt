package com.example.fetchrewardsexercise.di

import com.example.fetchrewardsexercise.data.network.UserApi
import retrofit2.Retrofit

fun provideUserApi(retrofit: Retrofit): UserApi =
    retrofit.create(UserApi::class.java)