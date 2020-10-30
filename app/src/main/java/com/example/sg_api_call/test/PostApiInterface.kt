package com.example.sg_api_call.test

import com.example.sg_api_call.test.CreatePostResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PostApiInterface {
    @FormUrlEncoded
    @POST("/posts")
    fun createPost(
        @Field("userId") userId:String,
        @Field("title") title:String,
        @Field("body") body:String
    ):Call<CreatePostResponse>
}
//"title":"Ankan",
//"body":"Mukherjee",
//"userId":1828049