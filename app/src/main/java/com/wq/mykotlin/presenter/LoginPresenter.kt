package com.wq.mykotlin.presenter

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import com.wq.mykotlin.bean.LoginBean
import com.wq.mykotlin.contract.LoginContract
import com.wq.mykotlin.model.LoginModel

class LoginPresenter:LoginContract.LoginPresenter{
    lateinit var loginModel: LoginModel
    lateinit var loginview:LoginContract.IloginView
    override fun login(params: HashMap<String, String>, context: Context) {
        loginModel.login(context,params,object :IModelCallback<LoginBean>{
            override fun sucess(data: LoginBean) {
               loginview?.success(data)
            }
            override fun failure(string: String) {
               loginview?.failure(string)
            }

        })
    }
    fun attach(loginview:LoginContract.IloginView){
        this.loginview=loginview;
        loginModel = LoginModel()
    }
    fun dattach(){
        if (loginview!=null){
            loginview==null
        }
    }
}