//package com.example.sg_api_call.Activities
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.sg_api_call.Api.RetrofitClient
//import com.example.sg_api_call.R
//import com.example.sg_api_call.model.DefaultResponse
//import kotlinx.android.synthetic.main.activity_signin.*
//import kotlinx.android.synthetic.main.activity_signin.password_edit_text
//import kotlinx.android.synthetic.main.activity_signup.*
//import kotlinx.android.synthetic.main.activity_signup.number_edit_text
//import kotlinx.android.synthetic.main.activity_user_details.*
////import org.jetbrains.anko.toast
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class SigninActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_signin)
//
//        signin_button.setOnClickListener {
//            val number = number_edit_text.text.toString().trim()
//            val password = password_edit_text.text.toString().trim()
//
//            if(number.isEmpty()){
//                number_edit_text.error = "Number required"
//                number_edit_text.requestFocus()
//                return@setOnClickListener
//            }
//
//            RetrofitClient.instance.userSignup(number)
//                .enqueue(object : Callback<DefaultResponse> {
//                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
//                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
//                    }
//
//                    override fun onResponse(
//                        call: Call<DefaultResponse>,
//                        response: Response<DefaultResponse>
//                    ) {
//                        Toast.makeText(
//                            applicationContext,
//                            response.body()?.message,
//                            Toast.LENGTH_LONG
//                        ).show()
//
//                    }
//
//                })
//        }
//    }
//}