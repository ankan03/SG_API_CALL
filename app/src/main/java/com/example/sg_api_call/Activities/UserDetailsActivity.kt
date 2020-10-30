//package com.example.sg_api_call.Activities
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.sg_api_call.Api.RetrofitClient
//import com.example.sg_api_call.R
//import com.example.sg_api_call.model.DefaultResponse
//import kotlinx.android.synthetic.main.activity_user_details.*
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class UserDetailsActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user_details)
//
//        update_user_button.setOnClickListener {
//
//            val email = email_edit_text.text.toString().trim()
//            val password = password_edit_text.text.toString().trim()
//            val name = name_edit_text.text.toString().trim()
//            val confirmPassword = confirm_password_edit_text.text.toString().trim()
//            val authToken = "kkkk"
//
//            if(email.isEmpty()){
//                email_edit_text.error = "Email required"
//                email_edit_text.requestFocus()
//                return@setOnClickListener
//            }
//
//
//            if(password.isEmpty()){
//                password_edit_text.error = "Password required"
//                password_edit_text.requestFocus()
//                return@setOnClickListener
//            }
//
//            if(name.isEmpty()){
//                name_edit_text.error = "Name required"
//                name_edit_text.requestFocus()
//                return@setOnClickListener
//            }
//
//            if(confirmPassword.isEmpty()){
//                confirm_password_edit_text.error = "Confirm Password required"
//                confirm_password_edit_text.requestFocus()
//                return@setOnClickListener
//            }
//
//
//            RetrofitClient.instance.userDetails(name,authToken,email,password)
//                .enqueue(object: Callback<DefaultResponse> {
//                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
//                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
//                    }
//
//                    override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
//                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
//                    }
//
//                })
//
//        }
//    }
//}