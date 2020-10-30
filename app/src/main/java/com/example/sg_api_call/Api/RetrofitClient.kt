package com.example.sg_api_call.Api

import android.util.Base64
import com.example.sg_api_call.Taran.Api
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val AUTH = "Basic "+ Base64.encodeToString("ankanmukherjee:123456".toByteArray(), Base64.NO_WRAP)

    private const val BASE_URL = "http://sg-prod.ap-south-1.elasticbeanstalk.com"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
//                .addHeader("Authorization", AUTH)
                .method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instance: Api by lazy{
        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
            .baseUrl("http://sg-prod.ap-south-1.elasticbeanstalk.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(Api::class.java)
    }
}