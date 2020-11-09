package hu.advertisersystem.advertiserlibrary.retrofit

import hu.advertisersystem.advertiserlibrary.model.Advertisement
import retrofit2.Call
import retrofit2.http.*

interface RetroFitAdvertisement {

    @Headers("Content-Type: application/json")
    @POST("/listadvertisements")
    fun getAdvertisements(@Body body: String) : Call<List<Advertisement>>

}