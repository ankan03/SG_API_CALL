//package com.example.sg_api_call.Room
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class TokenViewModel(application: Application) :AndroidViewModel(application){
////    var readAllData: LiveData<TokenModel>?=null
//    private var repository:TokenRepository?=null
//    init {
//        val tokenDao = TokenDatabase.getTokenDatabase(application).tokenDao()
//        repository = TokenRepository(tokenDao)
////        readAllData = repository.readAllData
//    }
//    fun addToken(tokenModel: TokenModel){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository?.addToken(tokenModel)
//        }
//    }
//    fun getToken(tokenModel: TokenModel){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository?.getToken(tokenModel)
//        }
//    }
//}