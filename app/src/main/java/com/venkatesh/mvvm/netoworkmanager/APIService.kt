package com.venkatesh.nearby.netoworkmanager

import com.venkatesh.mvvm.model.Fruites
import com.venkatesh.mvvm.netoworkmanager.BaseResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Venkatesh on 19/07/18.
 */
interface APIService {

    //https://api.myjson.com/bins/1bi8gs
    @GET("/bins/1bi8gs")
    fun getFruites():
            Call<BaseResponseModel>


    @GET
    fun dashboard(): Call<Any>
}