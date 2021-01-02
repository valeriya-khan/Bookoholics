package com.demo.bookaholics.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBookFactory {
    private static ApiBookFactory apiBookFactory;
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://www.googleapis.com/books/v1/";
    private static Object LOCK = new Object();
    public ApiBookFactory() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public static ApiBookFactory getInstance(){
        synchronized (LOCK){
            if(apiBookFactory==null){
                apiBookFactory = new ApiBookFactory();
            }
        }
        return apiBookFactory;
    }

    public ApiBookService getApiBookService(){
        return retrofit.create(ApiBookService.class);
    }
}
