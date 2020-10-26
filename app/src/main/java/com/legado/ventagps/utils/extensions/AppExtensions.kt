package com.legado.ventagps.utils.extensions

import com.legado.ventagps.activity.base.AppBaseActivity
import com.legado.ventagps.activity.base.BaseActivity
import com.legado.ventagps.model.CustomerListResponse
import com.legado.ventagps.model.LoginResponse
import com.legado.ventagps.model.RequestModel
import com.legado.ventagps.utils.Constants.SharedPref.DEFAULT_CURRENCY

fun  BaseActivity.signIn(email: String, password: String, onResult: (Boolean) -> Unit, onError: (String) -> Unit) {

     val requestModel = RequestModel()
    requestModel.username = email
    requestModel.password = password
   // showProgress(true)
    callApi(getRestApis(false).login(request = requestModel), onApiSuccess = {
        saveLoginResponse(it,false, password, onResult, onError)
    }, onApiError = {
        //showProgress(false)
        onResult(false)
        onError(it)
    }, onNetworkError = {
        //showProgress(false)
        //openLottieDialog() {
            signIn(email, password, onResult, onError)
     //   }
    })
}

fun  BaseActivity.listCustomers(username: String, onResult: (Boolean) -> Unit, onError: (String) -> Unit) {

    val requestModel = RequestModel()
    requestModel.usuario = "CHINCHAH"
    // showProgress(true)
    callApi(getRestApis(false).listarClientes(request = requestModel), onApiSuccess = {
        //saveLoginResponse(it,false, password, onResult, onError)
        toast("asasas");
    }, onApiError = {
        //showProgress(false)
        toast("error");
        onResult(false)
        onError(it)
    }, onNetworkError = {
        //showProgress(false)
        //openLottieDialog() {
        //signIn(email, password, onResult, onError)
        toast("error de red");
        //   }
    })
}

fun  BaseActivity.listCustomerResponse(it: CustomerListResponse,  username: String, onResult: (Boolean) -> Unit, onError: (String) -> Unit) {
//    if (it.user_role?.isNotEmpty()!!) {
//        if (it.user_role[0] == "administrator") {
//            //showProgress(false)
//            onError("Admin is not allowed")
//        } else {
//
//
////            callApi(getRestApis().retrieveCustomer(), onApiSuccess = { response ->
//
//                onResult(true)
////            }, onApiError = {
////
////            }, onNetworkError = {
////
////            })
//        }
//    }
    onResult(true)

}

fun  BaseActivity.saveLoginResponse(it: LoginResponse, isSocialLogin:Boolean, password: String, onResult: (Boolean) -> Unit, onError: (String) -> Unit) {
//    if (it.user_role?.isNotEmpty()!!) {
//        if (it.user_role[0] == "administrator") {
//            //showProgress(false)
//            onError("Admin is not allowed")
//        } else {
//
//
////            callApi(getRestApis().retrieveCustomer(), onApiSuccess = { response ->
//
//                onResult(true)
////            }, onApiError = {
////
////            }, onNetworkError = {
////
////            })
//        }
//    }
    onResult(true)

}

fun getDefaultCurrency(): String = ""//getSharedPrefInstance().getStringValue(DEFAULT_CURRENCY)
//fun getSharedPrefInstance(): SharedPrefUtils {
//    return if (WooBoxApp.sharedPrefUtils == null) {
//        WooBoxApp.sharedPrefUtils = SharedPrefUtils()
//        WooBoxApp.sharedPrefUtils!!
//    } else {
//        WooBoxApp.sharedPrefUtils!!
//    }
//}
