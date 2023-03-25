package com.duany.demo.services

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.duany.demo.models.CompositeIndices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IndexRepository {

    private val apiService: APIService by lazy {
        Retrofit.Builder()
            .baseUrl("https://example.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

    fun getIndexes(): LiveData<CompositeIndices> {
        val data = MutableLiveData<CompositeIndices>()
        apiService.getIndexes().enqueue(object : Callback<CompositeIndices> {
            override fun onResponse(
                call: Call<CompositeIndices>,
                response: Response<CompositeIndices>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<CompositeIndices>, t: Throwable) {
                Log.e(TAG, "Failed to get users", t)
            }
        })
        return data
    }

    companion object {
        private const val TAG = "IndexesRepository"
    }
}