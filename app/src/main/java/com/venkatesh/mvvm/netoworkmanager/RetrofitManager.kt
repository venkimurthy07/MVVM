package com.venkatesh.nearby.netoworkmanager

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.venkatesh.mvvm.BuildConfig
import com.venkatesh.nearby.enums.APIEnum
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Venkatesh on 19/07/18.
 */
class RetrofitManager {


    companion object {

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder().baseUrl("https://api.myjson.com/").client(provideOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create()).build()
        }

        class UrlInterceptor : Interceptor {

            override fun intercept(chain: Interceptor.Chain): okhttp3.Response? {
                val original = chain.request()

//            if (AuthenticationQuery.getProfile()?.token != null) {
//                request.newBuilder().addHeader("Authorization", "Bearer " + AuthenticationQuery.getProfile()?.token).build()
//            }
                val url = original.url().newBuilder()
                        .build()


                val request = original.newBuilder()
                        .method(original.method(), original.body()).url(url)
                        .build()

                return chain.proceed(request)
            }
        }

        fun provideOkHttpClient() = OkHttpClient.Builder()
                .addInterceptor(initHttpLoggingInterceptor())
                .addInterceptor(UrlInterceptor())
//                .connectTimeout(CovaCareConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
//                .writeTimeout(CovaCareConstants.WRITE_TIMEOUT, TimeUnit.SECONDS)
//                .readTimeout(CovaCareConstants.READ_TIMEOUT, TimeUnit.SECONDS)
                //.addInterceptor(BasicAuthInterceptor("prodcovacare", "fia0hsi6zxhm"))
                .build()

        fun initHttpLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
        }

        fun getApiService(): APIService {

            return getRetrofitInstance().create(APIService::class.java)
        }


    }


}