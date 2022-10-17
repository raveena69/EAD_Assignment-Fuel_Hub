package com.example.eadassignment_fuelhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eadassignment_fuelhub.stationOwner.LoginActivity;

public class MainActivity extends AppCompatActivity {

    Button stationOwnerLoginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stationOwnerLoginbutton = findViewById(R.id.stationOwnerLoginbutton);
        stationOwnerLoginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }
}