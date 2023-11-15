package com.android.consumeapi.util

sealed class Resource<T>(
    val data: T?= null,
    val errorMessage : String?= null
){
    class Success<T>(data: T, errorMessage: String?= null): Resource<T>(data, errorMessage)
    class Error<T>( errorMessage: String): Resource<T>(null,errorMessage)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}
