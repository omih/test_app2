package com.zcmx.bit.data.network.api.response;

import com.google.gson.annotations.SerializedName;

import com.zcmx.bit.data.model.dto.CarDto;

import java.util.List;

public class CarResponse {

    @SerializedName("OK")
    private String status;

    @SerializedName("data")
    private List<CarDto> cars;

    public String getStatus() {
        return status;
    }

    public List<CarDto> getCars() {
        return cars;
    }
}
