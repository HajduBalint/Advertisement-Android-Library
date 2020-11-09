package hu.advertisersystem.advertiserlibrary.retrofit

import hu.advertisersystem.advertiserlibrary.model.Advertisement
import hu.advertisersystem.advertiserlibrary.model.AdvertisementFilter
import retrofit2.Call
import retrofit2.http.*

interface RetroFitAdvertisement {

    @Headers("Content-Type: application/json")
    @POST("/listadvertisements")
    fun getAdvertisements(@Body body: AdvertisementFilter) : Call<List<Advertisement>>

}