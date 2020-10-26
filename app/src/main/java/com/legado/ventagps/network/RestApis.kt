package com.iqonic.woobox.network


import com.legado.ventagps.model.LoginResponse
import com.legado.ventagps.model.RequestModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface RestApis {


    @POST("jwt-auth/v1/token")
    fun login(@Body request: RequestModel): Call<LoginResponse>

    @GET("clientesByDiaV3")
    fun listarClientes(@Body request: RequestModel): Call<LoginResponse>

}
