package com.example.mehmetsabir.onboardingkotlin.views.connections

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestApiClient(restApiServiceUrl: String) {

    private var mRestApi: RestApi

    init {

        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
                .readTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(50, TimeUnit.SECONDS);

        val okHttpClient: OkHttpClient = builder.build()

        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(restApiServiceUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        mRestApi = retrofit.create(RestApi::class.java)

    }

    fun getRestApi(): RestApi {

        return mRestApi


    }

}