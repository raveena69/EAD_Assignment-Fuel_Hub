package com.example.eadassignment_fuelhub.stationOwner.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//References - https://www.digitalocean.com/community/tutorials/retrofit-android-example-tutorial
//             https://guides.codepath.com/android/consuming-apis-with-retrofit

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String url){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
