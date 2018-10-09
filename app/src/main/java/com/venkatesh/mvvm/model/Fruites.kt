package com.venkatesh.mvvm.model

import android.arch.lifecycle.ViewModel
import com.google.gson.annotations.SerializedName

class Fruites : ViewModel() {

    lateinit var name:String
    lateinit var price:String
}