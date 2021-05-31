package com.alaahossam.core.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import app.hatrick.core.network.*
import okhttp3.Headers.Companion.toHeaders
import okhttp3.Interceptor
import okhttp3.Response

@Suppress("DEPRECATION")
class ConnectivityInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val headers = mutableMapOf<String, String>().also {
            it["Content-Type"] = "application/x-www-form-urlencoded"
        }.toHeaders()

        val original = chain.request()

        val request = original.newBuilder()
            .headers(headers)
            .method(original.method, original.body)
            .build()

        if (!isNetworkAvailable())
            throw NoConnectivityException()

        val response = chain.proceed(request)

        when (response.code) {
            500 -> throw InternalServerException()
            404 -> throw NotFoundException()
            403 -> throw ExpiredTokenException()
            401 -> throw MissingTokenException()
        }
        return response
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
            }
        } else try {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) return true
        } catch (e: Exception) {
            Log.i("update_status", "" + e.message)
        }
        return false
    }
}
