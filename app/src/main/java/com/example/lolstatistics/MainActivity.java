package com.example.lolstatistics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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