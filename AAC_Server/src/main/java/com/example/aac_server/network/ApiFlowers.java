package com.example.aac_server.network;

import com.example.aac_server.model.Flowers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiFlowers {

    String BASE_URL = "http://yourdomain/test/flowers/public/";

    @GET("flowerset")
    Call<List<Flowers>> getFlowers();
}