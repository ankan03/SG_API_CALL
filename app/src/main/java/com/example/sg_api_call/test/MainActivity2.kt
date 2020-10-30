package com.example.sg_api_call.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sg_api_call.R
import kotlinx.android.synthetic.main.activity_main2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        submit_button.setOnClickListener {

            val title = title_edit_text.text.toString().trim()
            val body = body_edit_text.text.toString().trim()
            val userId = user_id_edit_text.text.toString().trim()

            if(title.isEmpty()){
                title_edit_text.error = "Title required"
                title_edit_text.requestFocus()
                return@setOnClickListener
            }

            if(body.isEmpty()){
                body_edit_text.error = "Body required"
                body_edit_text.requestFocus()
                return@setOnClickListener
            }

            if(userId.isEmpty()){
                user_id_edit_text.error = "UserId required"
                user_id_edit_text.requestFocus()
                return@setOnClickListener
            }

            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val api = retrofit.create(PostApiInterface::class.java)

            api.createPost(userId,title,body).enqueue(object : Callback<CreatePostResponse> {
                override fun onResponse(call: Call<CreatePostResponse>, response: Response<CreatePostResponse>) {
                    val postResponse = "Response Code: ${response.code()} \n" +
                            "Title : ${response.body()?.title} \n" +
                            "Body : ${response.body()?.body} \n" +
                            "UserId : ${response.body()?.userId} \n" +
                            "id : ${response.body()?.id} \n"

                    Log.d("Retrofit",postResponse)

                    post_responce.setText(postResponse)

                }
                override fun onFailure(call: Call<CreatePostResponse>, t: Throwable) {
                    Log.d("Retrofit","Error: ${t.message}")
                }
            })
        }
    }
}