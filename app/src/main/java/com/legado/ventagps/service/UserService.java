package com.legado.ventagps.service;

import com.legado.ventagps.model.CustomerListResponse;
import com.legado.ventagps.model.LoginResponse;
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

public interface UserService {

    @POST("login")
    Call<UserResponse> login(@Body User user);

    @GET("userByEmail")
    Call<UserResponse> userByEmail(@QueryMap Map<String, String> parametros);
    @PUT("updateUserLogin")
    Call<StatusResponse> updateUserLogin(@Body User user);
}
