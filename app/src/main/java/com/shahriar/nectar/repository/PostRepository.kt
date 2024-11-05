package com.shahriar.nectar.repository

import android.util.Log
import com.shahriar.nectar.api.ApiService
import com.shahriar.nectar.api.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class PostRepository @Inject constructor (private val apiService: ApiService) {

//    suspend fun getPosts(): Flow<ApiState<List<Post>>> = flow {
//        Log.d("Repository", "getPosts")
//        try {
//            emit(ApiState.Loading) // Emit loading state
//            val response = apiService.getPost() // Make the network request
//            Log.d("Repository", response.toString())
//            emit(ApiState.Success(response))
//        } catch (e: Exception) {
//            emit(ApiState.Error(e.message ?: "Unknown Error")) // Emit error state
//        }
//    }.flowOn(Dispatchers.IO)

}