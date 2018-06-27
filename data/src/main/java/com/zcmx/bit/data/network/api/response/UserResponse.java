package com.zcmx.bit.data.network.api.response;

import com.google.gson.annotations.SerializedName;

import com.zcmx.bit.data.model.dto.UserDto;

import java.util.List;

public class UserResponse {

    @SerializedName("OK")
    private String status;

    @SerializedName("data")
    private List<UserDto> users;

    public String getStatus() {
        return status;
    }

    public List<UserDto> getUsers() {
        return users;
    }
}
