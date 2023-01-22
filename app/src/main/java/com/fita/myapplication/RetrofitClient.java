package com.fita.myapplication;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
//    private static Retrofit retrofit = null;
    private static MyAPI api;

    public static MyAPI getRetrofitCLient(){
        if(api == null){
            String BASE_URL = "https://reqres.in/";
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.client(httpClient.build()).build();
            api = retrofit.create(MyAPI.class);
        }
        return api;
    }
}
