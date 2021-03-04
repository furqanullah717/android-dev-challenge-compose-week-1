package com.example.androiddevchallenge.utils

import DataResponse
import android.app.Activity
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

object Utils {
    private fun loadJSONFromAsset(activity: Activity): String? {
        return try {
            val `is`: InputStream = activity.assets.open("data.json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, charset(charsetName = "UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
    }

    fun getData(activity: Activity): DataResponse {
        val data =  loadJSONFromAsset(activity = activity)
        return Gson().fromJson(data, DataResponse::class.java)
    }

}