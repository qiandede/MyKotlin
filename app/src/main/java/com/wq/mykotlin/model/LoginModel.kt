package com.wq.mykotlin.model

import android.content.Context
import com.kotlinframework.net.network.*
import com.wq.mykotlin.api.Api
import com.wq.mykotlin.api.ApiService
import com.wq.mykotlin.bean.LoginBean
import com.wq.mykotlin.contract.LoginContract

class LoginModel: LoginContract.ILoginModel {
    override fun login(context: Context, params: HashMap<String, String>, modelCallback: IModelCallback<LoginBean>) {
        RetrofitManager.instance.createService(ApiService::class.java).login(Api.LOGIN_URL,params)
                .compose(NetScheduler.compose())
                .subscribe(object :NetResponseObserver<LoginBean>(context){
                    override fun success(data: LoginBean) {
                        modelCallback?.sucess(data)
                    }
                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                       modelCallback?.failure(apiErrorModel.message)
                    }

                })
    }

}