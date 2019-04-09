package com.wq.mykotlin.contract

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import com.wq.mykotlin.bean.LoginBean

interface LoginContract {
    interface LoginPresenter{
        fun login(params:HashMap<String,String>,context: Context)
    }
    interface ILoginModel{
        fun login( context: Context,params: HashMap<String, String>,modelCallback: IModelCallback<LoginBean>)
    }
    interface IloginView{
        fun success(loginBean: LoginBean)
        fun failure(string: String)
    }
}