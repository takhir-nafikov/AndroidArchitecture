package com.example.mvp_server.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerApi {
    @GET("flowers")
    Call<FlowerResponse> getAllFlowers();
}
