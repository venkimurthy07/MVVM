package com.venkatesh.nearby.netoworkmanager


import com.venkatesh.mvvm.netoworkmanager.BaseResponseModel
import com.venkatesh.nearby.enums.APIEnum
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by Venkatesh on 20/07/18.
 */
class APIServiceManager {

    companion object {
        lateinit var call: RetrofitLiveData<BaseResponseModel>

        fun cancel() {
            call.cancel()
        }
        fun apiCall(nearbyenum: APIEnum): RetrofitLiveData<BaseResponseModel> {
            val apicall = RetrofitManager.getApiService()
            when (nearbyenum) {
                APIEnum.NEARBYSEARCH -> {

                }
                APIEnum.DASHBOARD -> {
                    call = RetrofitLiveData(apicall.getFruites())
                }
            }

            return call
        }
    }
}