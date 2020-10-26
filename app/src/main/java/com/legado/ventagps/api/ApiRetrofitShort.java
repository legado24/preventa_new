package com.legado.ventagps.api;




import com.legado.ventagps.service.CustomerService;
import com.legado.ventagps.service.ProductService;
import com.legado.ventagps.service.UserService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by __Adrian__ on 17/5/2017.
 */

public class ApiRetrofitShort {
    private static ApiRetrofitShort instance = null;

    //public static final String BASE_URL = "http://190.223.55.172:8080/PreventaGps-2.3/preventaGps/";
    private CustomerService customerService;
    private UserService userService;
    private ProductService productService;


    public static ApiRetrofitShort getInstance(String BASE_URL) {
        if (instance == null) {
            instance = new ApiRetrofitShort(BASE_URL);
        }

        return instance;
    }
    private ApiRetrofitShort(String BASE_URL) {
        buildRetrofit(BASE_URL);
    }
    private okhttp3.OkHttpClient getRequestHeader() {
        return  new okhttp3.OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        Credentials.basic("adrian", "123456"));

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }

//        }).readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS).build();
        })
     .readTimeout(30, TimeUnit.SECONDS)
                 .connectTimeout(6, TimeUnit.SECONDS).build();
    }
    private void buildRetrofit(String url) {
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.create();

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(url).client(getRequestHeader())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();
        this.customerService = mRetrofit.create(CustomerService.class);
        this.userService=mRetrofit.create(UserService.class);
        this.productService=mRetrofit.create(ProductService.class);

    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public UserService getUserService() {
        return userService;
    }

    public ProductService getProductService() {
        return productService;
    }
}
