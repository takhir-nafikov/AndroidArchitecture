package com.example.mvvm_server.network;

import com.example.mvvm_server.model.Flowers;

import com.google.gson.annotations.SerializedName;
import java.util.List;


public class FlowersResponse {
    @SerializedName("result")
    public List<Flowers> listFlowers;
}
