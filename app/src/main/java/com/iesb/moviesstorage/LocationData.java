package com.iesb.moviesstorage;

public class LocationData {

    double latitude;
    double longitude;
    String idlocation;

    public LocationData(){

    }

    public LocationData(double latitude, double longitude, String id) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.idlocation = id;
    }


    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getIdlocation() {
        return idlocation;
    }
}
