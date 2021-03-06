package com.tosacisst.nwar.myapplication.connect

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {
    val BaseURL = "http://52.78.227.70:5001/api/"
    val httpClient = OkHttpClient.Builder()
    val builder = Retrofit.Builder()
        .baseUrl(BaseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
    val retrofit = builder.build()

    fun <T> createService(serviceClass: Class<T>) : T{
        return retrofit.create(serviceClass)
    }
}