package com.example.mvp_server.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlowerResponse {
    @SerializedName("result")
    @Expose
    private List<Flower> results;

    public FlowerResponse(List<Flower> results) {
        this.results = results;
    }

    public List<Flower> getResults() {
        return results;
    }

}
