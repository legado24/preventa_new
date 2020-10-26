package com.iqonic.woobox.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.multidex.BuildConfig
import com.google.gson.Gson
import com.iqonic.woobox.utils.extensions.checkIsEmpty
import com.iqonic.woobox.utils.extensions.showError
import com.legado.ventagps.PreVentaApp
import com.legado.ventagps.R
import com.legado.ventagps.activity.SignInUpActivity
import com.legado.ventagps.activity.base.BaseActivity
import com.legado.ventagps.api.ApiRetrofitShort
import com.legado.ventagps.fragment.BaseFragment
import com.legado.ventagps.model.Constants.Config.BASE_URL
import com.legado.ventagps.model.CustomerListResponse
import com.legado.ventagps.utils.extensions.*
import kotlinx.android.synthetic.main.fragment_sign_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class SignInFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etUserEmail.onFocusChangeListener = this
        etPassword.onFocusChangeListener = this
        etPassword.transformationMethod = biggerDotTranformation

        etUserEmail.setSelection(etUserEmail.length())
        btnSignIn.onClick { if (validate()) doLogin() }//validate()
//        tvForget.onClick { snackBar(context.getString(R.string.lbl_coming_soon)) }

        btnSignUp.onClick { (activity as SignInUpActivity).loadSignUpFragment() }
//        tvForget.onClick { showForgotPasswordDialog() }
    }

    private fun validate(): Boolean {
        return when {
            etUserEmail.checkIsEmpty() -> {
                etUserEmail.showError("Ingrese email")
                false
            }
            etPassword.checkIsEmpty() -> {
                etPassword.showError("Ingrese password")
                false
            }
            else -> true
       }

    }

    private fun doLogin() {
//        (activity as BaseActivity).signIn(
//            etUserEmail.textToString(),
//            etPassword.textToString(),
//            onResult = {
//                if (it) activity?.launchActivityWithNewTask<DashboardActivity>()
//            },
//            onError = {
//                activity?.snackBarError(it)
//            })
        val dataConsulta: MutableMap<String, String> =
            HashMap()
        dataConsulta["usuario"] = "CHINCHAH"
        val loginCall =
            ApiRetrofitShort.getInstance(BASE_URL).customerService
                .clientesByDiaV3(dataConsulta)

        loginCall.enqueue(object : Callback<CustomerListResponse> {
            override fun onResponse(
                call: Call<CustomerListResponse>,
                response: Response<CustomerListResponse>
            ) {
                when {
                    response.isSuccessful -> {
                        val body = response.body()
                        if (body != null) {
                            logData(
                                call.request(),
                                Gson().toJson(body),
                                response.raw().receivedResponseAtMillis() - response.raw()
                                    .sentRequestAtMillis()
                            )




                        } else {
                            logData(
                                call.request(),
                                "Response body is null",
                                response.raw().receivedResponseAtMillis() - response.raw()
                                    .sentRequestAtMillis(),
                                true
                            )
                        }
                    }
                    else -> {
                        val string = getJsonMsg(response.errorBody()!!)
                        logData(
                            call.request(),
                            string,
                            response.raw().receivedResponseAtMillis() - response.raw()
                                .sentRequestAtMillis(),
                            isError = true
                        )
                    }
                }
            }

            override fun onFailure(call: Call<CustomerListResponse>, t: Throwable) {
                if (!isNetworkAvailable()) {
                    //onNetworkError()
                    logData(
                        call.request(),
                        PreVentaApp.getAppInstance().resources.getString(R.string.error_no_internet),
                        isError = true
                    )
                } else {
                    if (!BuildConfig.DEBUG) {
                        //    onApiError("Please try again later.")
                    } else {
                        if (t.message != null) {
                            //    onApiError(t.message!!)}
                        }
                        if (t.message != null) {
                            logData(call.request(), t.message!!, isError = true)
                        }
                    }
                }
            }
        })
    }
    private fun showForgotPasswordDialog() {
//        val forgotPasswordDialog = Dialog(activity!!)
//        forgotPasswordDialog.window?.setBackgroundDrawable(ColorDrawable(0))
//        forgotPasswordDialog.setContentView(R.layout.dialog_forgot_password)
//        forgotPasswordDialog.window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
//
//        forgotPasswordDialog.apply {
//            this.btnForgotPassword.onClick {
//                forgotPasswordDialog.edtForgotEmail.hideSoftKeyboard()
//                if (forgotPasswordDialog.edtForgotEmail.textToString().isEmpty()) {
//                    toast("Please Enter Email")
//                    return@onClick
//                }
//                if (!forgotPasswordDialog.edtForgotEmail.isValidEmail()) {
//                    toast("Please Enter Valid Email")
//                    return@onClick
//                }
//
//                val requestModel = RequestModel()
//                requestModel.user_login = forgotPasswordDialog.edtForgotEmail.textToString()
//
//                callApi(getRestApis().forgetPassword(requestModel), onApiSuccess = {
//                    forgotPasswordDialog.edtForgotEmail.hideSoftKeyboard()
//                    toast(it.message ?: "")
//                    forgotPasswordDialog.dismiss()
//                }, onApiError = {
//                    toast(it)
//                }, onNetworkError = {
//                    toast(R.string.error_no_internet)
//                })
//            }
//
//            show()
//        }
    }
}