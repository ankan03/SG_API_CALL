package com.example.sg_api_call.Taran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import com.example.sg_api_call.R
import kotlinx.android.synthetic.main.activity_signup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signup_button.setOnClickListener {
            val number = number_edit_text.text.toString().trim()

            if(number.isEmpty()){
                number_edit_text.error = "Number required"
                number_edit_text.requestFocus()
                return@setOnClickListener
            }
            val retrofit = Retrofit.Builder()
//                .baseUrl("http://192.168.43.217:3000")
                .baseUrl("http://sg-backend-dev.ap-south-1.elasticbeanstalk.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val api = retrofit.create(Api::class.java)
            val number1 = Number(number)
            api.userSignup(number1).enqueue(object :Callback<AuthKey>{
                override fun onResponse(call: Call<AuthKey>, response: Response<AuthKey>) {
                    d("Ankan","OnResponse: ${response.body()?.message.toString()} \n"
                            +"Auth Token: ${response.body()?.auth_token.toString()} \n"
                            +"Response Code: ${response.code()}\n"
                            +"Response Error: ${response.errorBody().toString()}\n")
//                            + "response.errors[0].msg: ${response.body()?.errors?.get(0)?.msg} \n"
//                            + "response.errors[0].param: ${response.} \n"
//                            + "response.errors[0].location: ${response.errors[0].location} \n"
//                            )
                }
                override fun onFailure(call: Call<AuthKey>, t: Throwable) {
                    d("Ankan","OnFailure")
                }
            })
        }
    }
}