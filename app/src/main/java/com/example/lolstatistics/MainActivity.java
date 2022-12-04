package com.example.lolstatistics;

import static androidx.constraintlayout.widget.Constraints.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Giroscopio giroscopio;
    private Location location;
    private LocationManager locationManager;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        giroscopio = new Giroscopio(this);
        giroscopio.setListener(new Giroscopio.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {
                if (rz > 4.0f) {
                    Uri location = Uri.parse("geo:-23.51932141813161, -46.669311958238474");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                    } else {
                        startActivity(mapIntent);
                    }
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        giroscopio.registro();
    }

    @Override
    protected void onPause() {
        super.onPause();
        giroscopio.desRegistro();
    }


    public void AbrirGuiaAatrox(View view) {
        Intent intent = new Intent(this, ActivityAatrox.class);
        startActivity(intent);
    }

    public void AbrirGuiaAhri(View view) {
        Intent intent = new Intent(this, ActivityAhri.class);
        startActivity(intent);
    }

    public void AbrirGuiaAkali(View view) {
        Intent intent = new Intent(this, ActivityAkali.class);
        startActivity(intent);
    }

    public void AbrirGuiaAkshan(View view) {
        Intent intent = new Intent(this, ActivityAkshan.class);
        startActivity(intent);
    }

    public void AbrirGuiaAlistar(View view) {
        Intent intent = new Intent(this, ActivityAlistar.class);
        startActivity(intent);
    }

    public void AbrirSite(View view) {
        Uri uri = Uri.parse("https://www.leagueoflegends.com/pt-br/");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(Intent.createChooser(it, getString(R.string.chNavegador)));
    }

    public void AbrirYouTube(View view) {
        Uri uri = Uri.parse("https://www.youtube.com/c/RiotGamesBrasil");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }
    public void AbrirGuiaLoca(View view){
        Intent intent = new Intent(this,Localiza.class);
        startActivity(intent);
    }

    public void AbrirCadastro(View view){
        Intent intent = new Intent(this,RegistroUser.class);
        startActivity(intent);
    }

    public void AbrirFeed(View view){
        Intent intent = new Intent(this,FeedBack.class);
        startActivity(intent);
    }
}
