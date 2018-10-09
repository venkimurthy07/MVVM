package com.venkatesh.nearby.netoworkmanager

import android.arch.lifecycle.LiveData
import com.venkatesh.mvvm.netoworkmanager.BaseResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Error

class RetrofitLiveData<T>(private val call: Call<T>) : LiveData<T>(), Callback<T> {

    override fun onActive() {
        if (!call.isCanceled && !call.isExecuted) call.enqueue(this)
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        val response = BaseResponseModel()
        response.status = "Failure"
        value = response as T

    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        value = response?.body()
    }

    fun cancel() = if (!call.isCanceled) call.cancel() else Unit

}