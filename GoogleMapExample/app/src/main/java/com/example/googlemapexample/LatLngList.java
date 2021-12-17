package com.example.googlemapexample;

public class LatLngList {
    private String name;
    private String latlng;


    public LatLngList(String name, String latlng) {
        this.name = name;
        this.latlng = latlng;
    }

    public String getName(){
        return name;
    }
    public String getLatlng(){
        return latlng;
    }
}
