package com.artiuil.lab.recipiesapi.network

import okhttp3.Interceptor
import okhttp3.Response

internal class AuthInterceptor(
    private val apiKey: String,
    private val appId: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val urlWithParams = originalUrl.newBuilder()
            .addQueryParameter("app_key", apiKey)
            .addQueryParameter("app_id", appId)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(urlWithParams)
            .build()

        return chain.proceed(newRequest)
    }
}
