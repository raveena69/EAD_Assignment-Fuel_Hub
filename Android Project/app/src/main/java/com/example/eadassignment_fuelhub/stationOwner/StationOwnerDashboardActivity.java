package com.example.eadassignment_fuelhub.stationOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eadassignment_fuelhub.MainActivity;
import com.example.eadassignment_fuelhub.R;

public class StationOwnerDashboardActivity extends AppCompatActivity {

    TextView nameuser, walletuser, arrivalTime, network, plugins, finishTime, mainmenus,
            pagetitle, pagesubtitle;

    Button btnguide;
    Animation atg, atgtwo, atgthree;
    ImageView imageView3;

    LinearLayout fueltype;
    ImageView fueltype1;

    // button for logout
    private ImageView log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_owner_dashboard);

        getSupportActionBar().hide();
        nameuser = findViewById(R.id.nameuser);
        String emailfromIntent = getIntent().getStringExtra("EMAIL");
        nameuser.setText(emailfromIntent);

        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        atgtwo = AnimationUtils.loadAnimation(this, R.anim.atgtwo);
        atgthree = AnimationUtils.loadAnimation(this, R.anim.atgthree);

        nameuser = findViewById(R.id.nameuser);
        walletuser = findViewById(R.id.walletuser);

        imageView3 = findViewById(R.id.imageView3);

        arrivalTime = findViewById(R.id.arrivalTime);
//        finishTime = findViewById(R.id.finishTime);
//        network = findViewById(R.id.network);
        plugins = findViewById(R.id.plugins);
        mainmenus = findViewById(R.id.mainmenus);

        pagetitle = findViewById(R.id.pagetitle);
        pagesubtitle = findViewById(R.id.pagesubtitle);

        btnguide = findViewById(R.id.btnguide);

        btnguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(StationOwnerDashboardActivity.this, MainActivity.class);
                startActivity(a);
            }
        });

        fueltype = findViewById(R.id.fueltype);
        fueltype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StationOwnerDashboardActivity.this, FuelTypeDashboardActivity.class));
            }
        });

//        fueltype1 = findViewById(R.id.fueltype1);
//        fueltype1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(StationOwnerDashboardActivity.this, FuelTypeDashboardActivity.class));
//            }
//        });
//
//        arrivalTime = findViewById(R.id.arrivalTime);
//        arrivalTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(StationOwnerDashboardActivity.this, FuelTypeDashboardActivity.class));
//            }
//        });

        // pass an animation
        imageView3.startAnimation(atg);

        pagetitle.startAnimation(atgtwo);
        pagesubtitle.startAnimation(atgtwo);

        btnguide.startAnimation(atgthree);

        log_out = findViewById(R.id.log_out);
        // initializing click listener for logout button
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // calling a method to logout our user.
                Toast.makeText(StationOwnerDashboardActivity.this, "Station Owner Logged Out", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(StationOwnerDashboardActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
