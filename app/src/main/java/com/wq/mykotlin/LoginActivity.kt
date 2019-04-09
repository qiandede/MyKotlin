package com.wq.mykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wq.mykotlin.R.mipmap.login
import com.wq.mykotlin.bean.LoginBean
import com.wq.mykotlin.contract.LoginContract
import com.wq.mykotlin.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),LoginContract.IloginView, View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_login->loginUser();
        }
    }

    private fun loginUser() {
        var params = HashMap<String, String>()
        params.put("phone", ed_phone.text.toString())
        params.put("pwd",ed_password.text.toString())
        loginPresenter.attach(this)
        loginPresenter.login(params,this)
    }

    lateinit var loginPresenter: LoginPresenter
    override fun success(loginBean: LoginBean) {
        if (loginBean!=null){
            Toast.makeText(this, loginBean.message, Toast.LENGTH_SHORT).show()
        }
    }
    override fun failure(string: String) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
        initData()
    }

    private fun initData() {
        loginPresenter=LoginPresenter()
    }

    private fun initView() {
        btn_login.setOnClickListener(this)
    }
}
