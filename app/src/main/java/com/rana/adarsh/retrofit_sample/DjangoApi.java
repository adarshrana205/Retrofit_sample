package com.rana.adarsh.retrofit_sample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface DjangoApi {


    @GET("api/users_list/")
    Call<List<Post>>  getPosts(@Header("Authorization") String authHeader);

}
