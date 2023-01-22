package com.fita.myapplication;
import com.fita.myapplication.model.ListAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPI {

//    https://reqres.in/  api/users/

    @GET("api/users?page=2")
    Call<ListAPI> getList();


}
