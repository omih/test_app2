package com.zcmx.bit.data.model.dto;

import com.google.gson.annotations.SerializedName;

public class CarDto {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("info")
    private InfoDto info;

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

    public InfoDto getInfo() {
        return info;
    }

    public void setInfo(final InfoDto info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info=" + info +
                '}';
    }
}
