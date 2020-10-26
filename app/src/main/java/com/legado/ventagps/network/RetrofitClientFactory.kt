package com.iqonic.woobox.network

import android.app.Dialog
import com.google.gson.GsonBuilder
import com.iqonic.woobox.network.RetrofitClientFactory.Companion.okHttpClient
import com.iqonic.woobox.utils.oauthInterceptor.OAuthInterceptor
import com.legado.ventagps.model.Constants.Config.BASE_URL
//import com.legado.ventagps.utils.Constants.Config.consumerKey
//import com.legado.ventagps.utils.Constants.Config.consumerSecret
//import com.legado.ventagps.utils.Constants.Config.token
//import com.legado.ventagps.utils.Constants.Config.tokenSecret

import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
 import java.io.File
import java.util.concurrent.TimeUnit

class RetrofitClientFactory {

    companion object {

        var restApis: RestApis? = null
        var okHttpClient: OkHttpClient? = null




    }
    fun getRetroFitClient(b: Boolean = true): Retrofit {
        //val oauth1WooCommerce = OAuthInterceptor.Builder().consumerKey(consumerKey).consumerSecret(consumerSecret).token(token).tokenSecret(tokenSecret).build()

        val builder = OkHttpClient().newBuilder().connectTimeout(3, TimeUnit.MINUTES).readTimeout(3, TimeUnit.MINUTES)

        okHttpClient = if (b) {
//            builder.addInterceptor(ResponseInterceptor()).addInterceptor(oauth1WooCommerce).build()
            builder.addInterceptor(ResponseInterceptor()).build()
        } else {
            builder.addInterceptor(ResponseInterceptor()).build()
        }

        val gson = GsonBuilder().setLenient().disableHtmlEscaping().create()

        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient!!).addConverterFactory(GsonConverterFactory.create(gson)).build()
    }
}

class ResponseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        return response.newBuilder().body(ResponseBody.create(MediaType.parse("application/json; charset=utf-8"), response.body()!!.bytes())).build()
    }
}

fun cancelAllApi() {
    okHttpClient?.dispatcher()?.cancelAll()
}