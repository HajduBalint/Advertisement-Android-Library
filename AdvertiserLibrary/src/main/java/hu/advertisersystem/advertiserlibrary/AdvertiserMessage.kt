package hu.advertisersystem.advertiserlibrary

import android.content.Context
import android.widget.Toast

class AdvertiserMessage {

    fun toast(c: Context, message: String){
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show()
    }

}