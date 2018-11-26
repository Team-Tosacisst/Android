package com.tosacisst.nwar.myapplication.connect;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
    @GET("") Call<Void> get(@Header("Authorization") String authorization, @Path("z") String path);
    @POST("") Call<Void> post();
}
