package com.venkatesh.mvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.venkatesh.mvvm.adapter.DashboardAdapter
import com.venkatesh.mvvm.netoworkmanager.BaseResponseModel
import com.venkatesh.mvvm.viewmodel.DashboardViewModel
import com.venkatesh.nearby.enums.APIEnum
import com.venkatesh.nearby.netoworkmanager.APIServiceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fruites_recyclerview.layoutManager = LinearLayoutManager(this)




        makeFruitesAPICall()
        swipetorefresh.isRefreshing = true
        swipetorefresh.setOnRefreshListener {
            makeFruitesAPICall()
        }

    }

    fun makeFruitesAPICall() {
        ViewModelProviders.of(this).get(DashboardViewModel::class.java).getListOfFruites()
                .observe(this, object : Observer<BaseResponseModel> {
                    override fun onChanged(t: BaseResponseModel?) {
                        swipetorefresh.isRefreshing = false
                        if (t?.status.equals("success", true)) {
                            fruites_recyclerview.adapter = DashboardAdapter(t?.list!!)
                        } else {
                            Toast.makeText(applicationContext, "Failure", Toast.LENGTH_SHORT).show()
                        }
                    }

                })
    }
}
