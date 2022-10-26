package com.example.eadassignment_fuelhub.stationOwner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eadassignment_fuelhub.R;
import com.example.eadassignment_fuelhub.stationOwner.API.APIUtils;
import com.example.eadassignment_fuelhub.stationOwner.Model.FuelType;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuelTypeAdapter extends AppCompatActivity {

    private Context context;
    private List<FuelType> fuelTypes;

    public FuelTypeAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<FuelType> objects ) {
//        super(context, resource, objects);
        this.context = context;
        this.fuelTypes = objects;
    }

    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_fuel_type, parent, false);

        TextView txtUserId = (TextView) rowView.findViewById(R.id.txtFuelTypeId);
        TextView txtUsername = (TextView) rowView.findViewById(R.id.txtFuelTypeName);

        txtUserId.setText(String.format("#ID: %d", fuelTypes.get(pos).getId()));
        txtUsername.setText(String.format("FUEL TYPE NAME: %s", fuelTypes.get(pos).getFuelTypeName()));
        txtUsername.setText(String.format("FUEL TYPE ARRIVAL DATE: %s", fuelTypes.get(pos).getFuelTypeArrivalDate()));
        txtUsername.setText(String.format("FUEL TYPE ARRIVAL TIME: %s", fuelTypes.get(pos).getFuelTypeArrivalTime()));
        txtUsername.setText(String.format("FUEL TYPE FINISH DATE: %s", fuelTypes.get(pos).getFuelTypeFinishDate()));
        txtUsername.setText(String.format("FUEL TYPE FINISH TIME: %s", fuelTypes.get(pos).getFuelTypeFinishTime()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                Intent intent = new Intent(context, FuelTypeActivity.class);
                intent.putExtra("user_id", String.valueOf(fuelTypes.get(pos).getId()));
                intent.putExtra("fuel_type_name", fuelTypes.get(pos).getFuelTypeName());
                intent.putExtra("fuel_type_arrival_date", fuelTypes.get(pos).getFuelTypeArrivalDate());
                intent.putExtra("fuel_type_arrival_time", fuelTypes.get(pos).getFuelTypeArrivalTime());
                intent.putExtra("fuel_type_finish_date", fuelTypes.get(pos).getFuelTypeFinishDate());
                intent.putExtra("fuel_type_finish_time", fuelTypes.get(pos).getFuelTypeFinishTime());
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
