package com.example.aac_server.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Flowers implements Serializable {

    @SerializedName("flower_id")
    @Expose
    private long flower_id;

    @SerializedName("flower_img")
    @Expose
    private String flower_img;

    @SerializedName("flower_img_file")
    @Expose
    private String flower_img_file;

    @SerializedName("flower_rus")
    @Expose
    private String flower_rus;

    @SerializedName("flower_lat")
    @Expose
    private String flower_lat;

    @SerializedName("flower_desc")
    @Expose
    private String flower_desc;

    public Flowers(long flower_id, String flower_img, String flower_img_file,
                   String flower_rus, String flower_lat, String flower_desc) {
        this.flower_id = flower_id;
        this.flower_img = flower_img;
        this.flower_img_file = flower_img_file;
        this.flower_rus = flower_rus;
        this.flower_lat = flower_lat;
        this.flower_desc = flower_desc;
    }

    public long getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(long flower_id) {
        this.flower_id = flower_id;
    }

    public String getFlower_img() {
        return flower_img;
    }

    public void setFlower_img(String flower_img) {
        this.flower_img = flower_img;
    }

    public String getFlower_img_file() {
        return flower_img_file;
    }

    public void setFlower_img_file(String flower_img_file) {
        this.flower_img_file = flower_img_file;
    }

    public String getFlower_rus() {
        return flower_rus;
    }

    public void setFlower_rus(String flower_rus) {
        this.flower_rus = flower_rus;
    }

    public String getFlower_lat() {
        return flower_lat;
    }

    public void setFlower_lat(String flower_lat) {
        this.flower_lat = flower_lat;
    }

    public String getFlower_desc() {
        return flower_desc;
    }

    public void setFlower_desc(String flower_desc) {
        this.flower_desc = flower_desc;
    }
}
