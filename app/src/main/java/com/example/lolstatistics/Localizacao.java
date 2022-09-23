package com.example.lolstatistics;

import android.location.Location;
import android.location.LocationListener;

import androidx.annotation.NonNull;

public class Localizacao implements LocationListener{
    public static double latitude,
            longitude;
    @Override
    public void onLocationChanged(@NonNull Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }

    public double getLat(){
        return latitude;
    }
    public double getLon(){
        return longitude;
    }
}
