package hu.advertisersystem.advertiserlibrary

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import hu.advertisersystem.advertiserlibrary.model.Advertisement
import hu.advertisersystem.advertiserlibrary.model.AdvertisementFilter
import hu.advertisersystem.advertiserlibrary.retrofit.OkHttpClient
import hu.advertisersystem.advertiserlibrary.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class AdvertisementLibrary(private val context: Context){

    fun advertisements(filter: AdvertisementFilter, callback: AdvertisementSystemCallBack){
        var apiKey: String

        context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
            .apply {
                apiKey = metaData.getString("advertisement.system.API_KEY")!!
            }

        OkHttpClient.setAPIKey(apiKey)
        OkHttpClient.setAppId(context.packageName)
        RetrofitClient.createAdvertisementService()
        val call = RetrofitClient.advertisementService!!.getAdvertisements(filter)

        call.enqueue(object : Callback<List<Advertisement>> {
            override fun onFailure(call: Call<List<Advertisement>>, t: Throwable) {
                callback.onFailed()
            }

            override fun onResponse(call: Call<List<Advertisement>>, response: Response<List<Advertisement>>) {
                when(response.code()){
                    200 -> {
                        callback.onSuccess(response.body()!!)
                    }
                    else -> {
                        callback.onFailed()
                        Log.d("advertisements", "response code: ${response.code()}")
                    }
                }
            }
        })
    }

    interface AdvertisementSystemCallBack{
        fun onSuccess(advertisements: List<Advertisement>)

        fun onFailed()
    }
}