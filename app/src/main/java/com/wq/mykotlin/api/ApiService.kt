package com.wq.mykotlin.api

import com.wq.mykotlin.bean.LoginBean
import com.wq.mykotlin.bean.RegisterBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url
import kotlin.collections.HashMap

interface ApiService {
    @POST
    @FormUrlEncoded
    fun login(@Url url:String,@FieldMap params:HashMap<String,String>):Observable<LoginBean>

    @POST
    @FormUrlEncoded
    fun register(@Url url:String,@FieldMap params:HashMap<String,String>):Observable<RegisterBean>
}