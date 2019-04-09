package com.wq.mykotlin.app

import android.app.Application
import com.kotlinframework.net.network.RetrofitManager
import com.wq.mykotlin.api.Api

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        RetrofitManager.instance.init(Api.BASE_URL)
    }
}