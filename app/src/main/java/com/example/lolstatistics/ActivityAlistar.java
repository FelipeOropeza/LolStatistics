package com.example.lolstatistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityAlistar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alistar);
    }
    public void VoltaGuia(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}