package com.jozze.core.common

import android.util.Log

//object LogUtil {
//    fun log(
//        tag: String = Constants.TAG_DEFAULT,
//        message: String,
//        logLevel: LogLevel = LogLevel.VERBOSE
//    ) {
//        when (logLevel) {
//            LogLevel.VERBOSE -> Log.v(tag, message)
//            LogLevel.INFO -> Log.i(tag, message)
//            LogLevel.DEBUG -> Log.d(tag, message)
//            LogLevel.WARNING -> Log.w(tag, message)
//            LogLevel.ERROR -> Log.e(tag, message)
//        }
//    }
//}

enum class LogLevel {
    VERBOSE, INFO, DEBUG, WARNING, ERROR
}

fun log(message: String, tag: String = Constants.TAG_DEFAULT, level: LogLevel = LogLevel.VERBOSE) {
    when (level) {
        LogLevel.VERBOSE -> Log.v(tag, message)
        LogLevel.INFO -> Log.i(tag, message)
        LogLevel.DEBUG -> Log.d(tag, message)
        LogLevel.WARNING -> Log.w(tag, message)
        LogLevel.ERROR -> Log.e(tag, message)
    }
}

fun log(message: String, tag: String = Constants.TAG_DEFAULT) {
    println("$tag -> $message")
}