package com.zcmx.bit.data.model.dto;

import com.google.gson.annotations.SerializedName;

public class UserDto {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("carId")
    private Long carId;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(final Long carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", carId=" + carId +
                '}';
    }
}
