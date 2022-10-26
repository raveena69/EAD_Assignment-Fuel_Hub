package com.example.eadassignment_fuelhub.stationOwner.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FuelType {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("FuelTypeId")
    @Expose
    private String FuelTypeId;

    @SerializedName("FuelTypeName")
    @Expose
    private String FuelTypeName;

    @SerializedName("FuelTypeArrivalTime")
    @Expose
    private String FuelTypeArrivalTime;

    @SerializedName("FuelTypeArrivalDate")
    @Expose
    private String FuelTypeArrivalDate;

    @SerializedName("FuelTypeFinishTime")
    @Expose
    private String FuelTypeFinishTime;

    @SerializedName("FuelTypeFinishDate")
    @Expose
    private String FuelTypeFinishDate;

    public FuelType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuelTypeId() {
        return FuelTypeId;
    }

    public void setFuelTypeId(String fuelTypeId) {
        FuelTypeId = fuelTypeId;
    }

    public String getFuelTypeName() {
        return FuelTypeName;
    }

    public void setFuelTypeName(String fuelTypeName) {
        FuelTypeName = fuelTypeName;
    }

    public String getFuelTypeArrivalTime() {
        return FuelTypeArrivalTime;
    }

    public void setFuelTypeArrivalTime(String fuelTypeArrivalTime) {
        FuelTypeArrivalTime = fuelTypeArrivalTime;
    }

    public String getFuelTypeArrivalDate() {
        return FuelTypeArrivalDate;
    }

    public void setFuelTypeArrivalDate(String fuelTypeArrivalDate) {
        FuelTypeArrivalDate = fuelTypeArrivalDate;
    }

    public String getFuelTypeFinishTime() {
        return FuelTypeFinishTime;
    }

    public void setFuelTypeFinishTime(String fuelTypeFinishTime) {
        FuelTypeFinishTime = fuelTypeFinishTime;
    }

    public String getFuelTypeFinishDate() {
        return FuelTypeFinishDate;
    }

    public void setFuelTypeFinishDate(String fuelTypeFinishDate) {
        FuelTypeFinishDate = fuelTypeFinishDate;
    }
}
