package com.example.eadassignment_fuelhub.stationOwner;
import com.example.eadassignment_fuelhub.stationOwner.Model.FuelType;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FuelTypeService {

    @GET("/fueltype/")
    Call<List<FuelType>> getFuelTypes();

    @POST("/fueltype/add/")
    Call<FuelType> addFuelType(@Body FuelType fueltype);

    @PUT("/fueltype/update/{id}")
    Call<FuelType> updateFuelType(@Path("id") int id, @Body FuelType fueltype);

    @PUT("/fueltype/update")
    Call<FuelType> updateFuelType1(@Path("id") int id, @Body FuelType fueltype);

    @DELETE("/fueltype/delete/{id}")
    Call<FuelType> deleteFuelType(@Path("id") int id);
}
