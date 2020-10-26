package com.legado.ventagps.service;

import com.legado.ventagps.model.ProductListResponse;
import com.legado.ventagps.model.StatusResponse;
import com.legado.ventagps.model.User;
import com.legado.ventagps.model.UserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;

public interface ProductService {

    @GET("bonifItem")
    Call<ProductListResponse> bonifItem(@QueryMap Map<String, String> parametros);

}
