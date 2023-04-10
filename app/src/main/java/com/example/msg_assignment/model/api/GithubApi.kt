package com.example.msg_assignment.model.api

import com.example.msg_assignment.model.data.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object GithubApi {
    private const val BASE_URL = "https://api.github.com/"

    private var httpLoginInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor { println("안녕: $it") }
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoginInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: GithubService = retrofit.create(GithubService::class.java)

    suspend fun searchUser(userName: String): Response<User> {
        return service.searchUser(userName)
    }

    interface GithubService {
        @GET("users/{username}")
        suspend fun searchUser(@Path("username") userName: String): Response<User>
    }
}