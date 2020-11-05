package hu.advertisersystem.advertiserlibrary.retrofit

import com.google.gson.GsonBuilder
import hu.advertisersystem.advertiserlibrary.retrofit.OkHttpClient.getOkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "localhost:8080"
    var advertisementService: RetroFitAdvertisement? = null

    fun createAdvertisementService(){
        if(advertisementService == null){
            advertisementService = Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                .build()
                .create(RetroFitAdvertisement::class.java)
        }
    }
}