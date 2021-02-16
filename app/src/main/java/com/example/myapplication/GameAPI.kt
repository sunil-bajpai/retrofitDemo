package com.example.myapplication

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


object GameAPI {
    private const val BASE_URL = "https://www.gamerpower.com/api/"
    var gameAPIService: GameAPIService? = null

    //create gson instance
    var gson = GsonBuilder().create()

    //create gameAPIService instance
    val service: GameAPIService?
        get() {
            if (gameAPIService == null) {
                //create gameAPISrvice instance;
                val retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
                gameAPIService = retrofit.create(GameAPIService::class.java)
            }
            return gameAPIService
        }

    interface GameAPIService {
        @get:GET("giveaways")
        val gameGiveaways: Call<List<RetrofitDemo?>>?

        @get:GET("worth")
        val gameGiveawaysWorth: Call<List<RetrofitDemo?>>?
    }
}