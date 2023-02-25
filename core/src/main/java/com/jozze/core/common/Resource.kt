package com.jozze.core.common

sealed class Resource<T> {
    class Success<T>(val data: T) : Resource<T>()
    class Failure<T>(val data: T?, val message: String = "some error occurred") : Resource<T>()
    class Loading<T>(val loading: Boolean = true) : Resource<T>()
}