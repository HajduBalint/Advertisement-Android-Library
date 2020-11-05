package hu.advertisersystem.advertiserlibrary.retrofit

import hu.advertisersystem.advertiserlibrary.model.Advertisement
import retrofit2.Call
import retrofit2.http.*

interface RetroFitAdvertisement {

    @Headers("Content-Type: application/json")
    @GET("/listadvertisements")
    fun getAdvertisements() : Call<List<Advertisement>>

}