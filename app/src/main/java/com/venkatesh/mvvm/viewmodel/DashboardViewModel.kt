package com.venkatesh.mvvm.viewmodel

import android.arch.lifecycle.ViewModel
import com.venkatesh.mvvm.model.Fruites
import com.venkatesh.mvvm.netoworkmanager.BaseResponseModel
import com.venkatesh.nearby.enums.APIEnum
import com.venkatesh.nearby.netoworkmanager.APIServiceManager
import com.venkatesh.nearby.netoworkmanager.RetrofitLiveData

class DashboardViewModel : ViewModel() {

    lateinit var name:String

    fun getListOfFruites() : RetrofitLiveData<BaseResponseModel>{

        if(APIServiceManager.apiCall(APIEnum.DASHBOARD) is RetrofitLiveData<BaseResponseModel>){
            return APIServiceManager.apiCall(APIEnum.DASHBOARD)
        }

        return APIServiceManager.apiCall(APIEnum.DASHBOARD)
    }

}