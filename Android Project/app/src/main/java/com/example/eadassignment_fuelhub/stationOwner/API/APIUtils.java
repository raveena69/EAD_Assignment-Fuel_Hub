package com.example.eadassignment_fuelhub.stationOwner.API;

import com.example.eadassignment_fuelhub.stationOwner.FuelTypeService;
import com.example.eadassignment_fuelhub.stationOwner.Model.FuelType;

//References - https://www.digitalocean.com/community/tutorials/retrofit-android-example-tutorial
//             https://guides.codepath.com/android/consuming-apis-with-retrofit

public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "http://192.168.8.105:5000/api/";

    public static FuelTypeService getFuelTypeService(){
        return RetrofitClient.getClient(API_URL).create(FuelTypeService.class);
    }

}
