package com.example.lolstatistics;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_Corde extends AppCompatActivity {
    private TextView txtLongitude;
    private TextView txtLatitude;
    private Location location;
    private LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corde);

        txtLongitude = (TextView) findViewById(R.id.txtLogintude);
        txtLatitude = (TextView) findViewById(R.id.txtLatitude);

        double latitude = 0.0;
        double longitude = 0.0;
        
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission,ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){

        }else{

        }
    }
}