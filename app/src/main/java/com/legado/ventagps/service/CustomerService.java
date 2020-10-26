package com.legado.ventagps.service;

import com.legado.ventagps.model.CustomerListResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface CustomerService {

    @GET("clientesByDiaV3")
    Call<CustomerListResponse> clientesByDiaV3(@QueryMap Map<String, String> parametros);
}

