package com.example.sg_api_call.Taran

import com.example.sg_api_call.model.DefaultResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("/students/signup")
    fun userSignup(
        @Field("number") number:String
    ): Call<AuthKey>

//    @FormUrlEncoded
//    @POST("/students/signup")
//    fun userSignup(
//        @Field("number") number:String
//    ): Call<AuthKey>

    @FormUrlEncoded
    @POST("/students/createdetails")
    fun userDetails(
        @Field("name") name: String,
        @Field("auth_token") auth_token:String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<DefaultResponse>

    @FormUrlEncoded
    @POST("/students/signin")
    fun userSignin(
        @Field("number") number:String,
        @Field("password") password:String
    ): Call<DefaultResponse>


}