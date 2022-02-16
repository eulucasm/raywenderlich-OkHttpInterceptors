package com.raywenderlich.android.watchlist.network.intercetors

import com.raywenderlich.android.watchlist.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {

   private val apiKeyQueryParameterKey = "api_key"

   override fun intercept(chain: Interceptor.Chain): Response {
      val originalRequest = chain.request()
      val originalUrl = originalRequest.url

      val url = originalUrl.newBuilder()
         .addQueryParameter("api_key", BuildConfig.THE_MOVIE_DB_API_TOKEN)
         .build()

      val newRequest = originalRequest.newBuilder()
         .url(url)
         .build()

      return chain.proceed(newRequest)
   }
}