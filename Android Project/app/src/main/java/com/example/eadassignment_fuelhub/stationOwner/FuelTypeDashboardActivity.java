package com.example.eadassignment_fuelhub.stationOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eadassignment_fuelhub.MainActivity;
import com.example.eadassignment_fuelhub.R;
import com.example.eadassignment_fuelhub.stationOwner.API.APIUtils;
import com.example.eadassignment_fuelhub.stationOwner.Model.FuelType;

public class FuelTypeDashboardActivity extends AppCompatActivity {

    Button btnAddFuelType;
    Button btnGetFuelTypesList;
    ListView listView;

    FuelTypeService fuelTypeService;
    List<FuelType> list = new ArrayList<FuelType>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_type_dashboard);

        setTitle("Fuel Type");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnAddFuelType = (Button) findViewById(R.id.btnAddFuelType);
        btnGetFuelTypesList = (Button) findViewById(R.id.btnGetFuelTypesList);
        listView = (ListView) findViewById(R.id.listView);
        fuelTypeService = APIUtils.getFuelTypeService();

        btnGetFuelTypesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get users list
                getFuelTypesList();
            }
        });

        btnAddFuelType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FuelTypeDashboardActivity.this, FuelTypeActivity.class);
                intent.putExtra("fuel_type_name", "");
                startActivity(intent);
            }
        });
    }

    public void getFuelTypesList(){
        Call<List<FuelType>> call = fuelTypeService.getFuelTypes();
        call.enqueue(new Callback<List<FuelType>>() {
            @Override
            public void onResponse(Call<List<FuelType>> call, Response<List<FuelType>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    listView.setAdapter((ListAdapter) new FuelTypeAdapter(FuelTypeDashboardActivity.this, R.layout.list_fuel_type, list));
                    Log.d(String.valueOf(listView), "Get data");
                }
            }

            @Override
            public void onFailure(Call<List<FuelType>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}
