package com.example.webretrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectAPI {
    public final static String url_base = "http://192.168.1.6:8081/";
    private static Retrofit retrofit;

    public static Retrofit retrofitConnectAPI(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url_base)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
