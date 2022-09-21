package com.example.lolstatistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Giroscopio giroscopio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        giroscopio = new Giroscopio(this);

        giroscopio.setListener(new Giroscopio.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {
                if(rz > 1.0f){
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                }
            }
        });

    }
        @Override
        protected void onResume(){
        super.onResume();
        giroscopio.registro();
    }
    @Override
    protected void onPause(){
        super.onPause();
        giroscopio.desRegistro();
    }


    public void AbrirGuiaAatrox(View view){
        Intent intent = new Intent(this, ActivityAatrox.class);
        startActivity(intent);
    }
    public void AbrirGuiaAhri(View view){
        Intent intent = new Intent(this, ActivityAhri.class);
        startActivity(intent);
    }
    public void AbrirGuiaAkali(View view){
        Intent intent = new Intent(this, ActivityAkali.class);
        startActivity(intent);
    }
    public void AbrirGuiaAkshan(View view){
        Intent intent = new Intent(this, ActivityAkshan.class);
        startActivity(intent);
    }
    public void AbrirGuiaAlistar(View view){
        Intent intent = new Intent(this, ActivityAlistar.class);
        startActivity(intent);
    }
}