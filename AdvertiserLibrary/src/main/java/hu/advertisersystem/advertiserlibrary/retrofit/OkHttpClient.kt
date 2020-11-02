package hu.advertisersystem.advertiserlibrary.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object OkHttpClient {
    private var APIKey: String? = null
    private var appId: String? = null

    fun getOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .addInterceptor{chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("api-key", APIKey!!)
                    .addHeader("application-id", appId!!)
                    .build()
                chain.proceed(newRequest)
            }
            .build()
    }
    fun setAPIKey(apiKey: String){
        APIKey = apiKey
    }

    fun setAppId(applicationId: String){
        appId = applicationId
    }
}