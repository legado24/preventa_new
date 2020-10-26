package com.legado.ventagps

import android.app.Dialog
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.iqonic.woobox.network.RestApis

import okhttp3.OkHttpClient
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class PreVentaApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this


//        // Set Custom Font
//        CalligraphyConfig.initDefault(
//                CalligraphyConfig.Builder().setDefaultFontPath(getString(R.string.font_regular)).setFontAttrId(
//                        R.attr.fontPath
//                ).build()
//        )




    }


    companion object {

        private lateinit var appInstance: PreVentaApp
        var restApis: RestApis? = null
        var okHttpClient: OkHttpClient? = null
         var noInternetDialog: Dialog? = null
        lateinit var language: String
        var appTheme: Int = 0

        fun getAppInstance(): PreVentaApp {
            return appInstance
        }




    }
}
