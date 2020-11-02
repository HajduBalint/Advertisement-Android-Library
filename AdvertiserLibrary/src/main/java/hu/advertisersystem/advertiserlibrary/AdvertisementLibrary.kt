package hu.advertisersystem.advertiserlibrary

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import hu.advertisersystem.advertiserlibrary.model.Advertisement
import hu.advertisersystem.advertiserlibrary.retrofit.OkHttpClient
import hu.advertisersystem.advertiserlibrary.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class AdvertisementLibrary(private val context: Context) {

    fun advertisements(): List<Advertisement>{
        var apiKey: String

        context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
            .apply {
                apiKey = metaData.getString(context.packageName+"API_KEY")!!
            }

        var advertisementList = listOf<Advertisement>()
        OkHttpClient.setAPIKey(apiKey)
        OkHttpClient.setAppId(context.packageName)
        RetrofitClient.createAdvertisementService()
        val call = RetrofitClient.advertisementService!!.getAdvertisements()

        call.enqueue(object : Callback<List<Advertisement>> {
            override fun onFailure(call: Call<List<Advertisement>>, t: Throwable) {
                Log.d("advertisements","failure", t)
            }

            override fun onResponse(call: Call<List<Advertisement>>, response: Response<List<Advertisement>>) {
                when(response.code()){
                    200 -> {
                        advertisementList = response.body()!!
                    }
                    else -> {
                        Log.d("advertisements", "response code: ${response.code()}")
                    }
                }
            }
        })
        return advertisementList
    }
}