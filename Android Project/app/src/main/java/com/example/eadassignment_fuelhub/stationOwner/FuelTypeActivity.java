package com.example.eadassignment_fuelhub.stationOwner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eadassignment_fuelhub.R;
import com.example.eadassignment_fuelhub.stationOwner.API.APIUtils;
import com.example.eadassignment_fuelhub.stationOwner.Model.FuelType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuelTypeActivity extends AppCompatActivity {

    FuelTypeService fueltypeService;
    EditText edtId;
    EditText edtFuelTypeName, edtFuelTypeArrivalTime, edtFuelTypeArrivalDate, edtFuelTypeFinishTime, edtFuelTypeFinishDate;
    Button btnSave;
    Button btnDel;
    TextView txtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_type);

        setTitle("FuelType");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtId = findViewById(R.id.txtId);
        edtId = findViewById(R.id.edtId);
        edtFuelTypeName = findViewById(R.id.edtFuelTypeName);
        edtFuelTypeArrivalTime = findViewById(R.id.edtFuelTypeArrivalTime);
        edtFuelTypeArrivalDate = findViewById(R.id.edtFuelTypeArrivalDate);
        edtFuelTypeFinishTime = findViewById(R.id.edtFuelTypeFinishTime);
        edtFuelTypeFinishDate = findViewById(R.id.edtFuelTypeFinishDate);
        btnSave = findViewById(R.id.btnSave);
        btnDel = findViewById(R.id.btnDel);

        fueltypeService = APIUtils.getFuelTypeService();

        Bundle extras = getIntent().getExtras();
        final String fueltypeId = extras.getString("fuel_type_id");
        String fueltypeName = extras.getString("fuel_type_name");
        String fueltypeArrivalTime = extras.getString("fuel_type_arrival_time");
        String fueltypeArrivalDate = extras.getString("fuel_type_arrival_date");
        String fueltypeFinishTime = extras.getString("fuel_type_finish_time");
        String fueltypeFinishDate = extras.getString("fuel_type_finish_date");

        edtId.setText(fueltypeId);
        edtFuelTypeName.setText(fueltypeName);
        edtFuelTypeArrivalTime.setText(fueltypeArrivalTime);
        edtFuelTypeArrivalDate.setText(fueltypeArrivalDate);
        edtFuelTypeFinishTime.setText(fueltypeFinishTime);
        edtFuelTypeFinishDate.setText(fueltypeFinishDate);

        if(fueltypeId != null && fueltypeId.trim().length() > 0 ){
            edtId.setFocusable(false);
        } else {
            txtId.setVisibility(View.INVISIBLE);
            edtId.setVisibility(View.INVISIBLE);
            btnDel.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FuelType fuelType = new FuelType();
                fuelType.setFuelTypeName(edtFuelTypeName.getText().toString());
                fuelType.setFuelTypeArrivalTime(edtFuelTypeArrivalTime.getText().toString());
                fuelType.setFuelTypeArrivalDate(edtFuelTypeArrivalDate.getText().toString());
                fuelType.setFuelTypeFinishTime(edtFuelTypeFinishTime.getText().toString());
                fuelType.setFuelTypeFinishDate(edtFuelTypeFinishDate.getText().toString());
                if(fueltypeId != null && fueltypeId.trim().length() > 0){
                    //update user
                    updateFuelType(Integer.parseInt(fueltypeId), fuelType);
                    updateFuelType(Integer.parseInt(fueltypeName), fuelType);
                    updateFuelType(Integer.parseInt(fueltypeArrivalTime), fuelType);
                    updateFuelType(Integer.parseInt(fueltypeArrivalDate), fuelType);
                    updateFuelType(Integer.parseInt(fueltypeFinishTime), fuelType);
                    updateFuelType(Integer.parseInt(fueltypeFinishDate), fuelType);
                } else {
                    //add user
                    addFuelType(fuelType);
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFuelType(Integer.parseInt(fueltypeId));

                Intent intent = new Intent(FuelTypeActivity.this, FuelTypeDashboardActivity.class);
                startActivity(intent);
            }
        });

    }

    public void addFuelType(FuelType fuelType){
        Call<FuelType> call = fueltypeService.addFuelType(fuelType);
        call.enqueue(new Callback<FuelType>() {
            @Override
            public void onResponse(Call<FuelType> call, Response<FuelType> response) {
                if(response.isSuccessful()){
                    Toast.makeText(FuelTypeActivity.this, "New Fuel Type created successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FuelType> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void updateFuelType(int id, FuelType fuelType){
        Call<FuelType> call = fueltypeService.updateFuelType(id, fuelType);
        call.enqueue(new Callback<FuelType>() {
            @Override
            public void onResponse(Call<FuelType> call, Response<FuelType> response) {
                if(response.isSuccessful()){
                    Toast.makeText(FuelTypeActivity.this, "Fuel Type updated successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FuelType> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void deleteFuelType(int id){
        Call<FuelType> call = fueltypeService.deleteFuelType(id);
        call.enqueue(new Callback<FuelType>() {
            @Override
            public void onResponse(Call<FuelType> call, Response<FuelType> response) {
                if(response.isSuccessful()){
                    Toast.makeText(FuelTypeActivity.this, "Fuel Type deleted successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FuelType> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
