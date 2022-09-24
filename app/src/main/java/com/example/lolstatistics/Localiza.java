package com.example.lolstatistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Localiza extends AppCompatActivity {
    private TextView txtLatitude;
    private TextView txtLongitude;
    private Location location;
    private LocationManager locationManager;

    public Localiza() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localiza);
        txtLatitude = (TextView) findViewById(R.id.txtLatitude);
        txtLongitude = (TextView) findViewById(R.id.txtLongitude);
    }
    public void mostrarLocal(View view){
        double longitude = 0;
        double latitude = 0;

        if(ActivityCompat.checkSelfPermission(Localiza.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Localiza.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else{
            locationManager = (LocationManager)
                    getSystemService(Context.LOCATION_SERVICE);
            location =
                    locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
        if (location != null){
            longitude = location.getLongitude();
            latitude = location.getLatitude();
        }
        txtLongitude.setText("Longitude: " +  String.valueOf(longitude));
        txtLatitude.setText("Latitude: " + String.valueOf(latitude));
    }
    public void VoltaGuia(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}