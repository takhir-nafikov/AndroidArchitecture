package com.example.mvvm_server.network;

import retrofit2.http.GET;

public interface ICall {
    @GET("flowers")
    retrofit2.Call<FlowersResponse> getAllFlowers();
}
