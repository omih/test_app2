package com.zcmx.bit.data.model.dto;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

public class InfoDto {

    @SerializedName("date")
    private DateTime date;

    @SerializedName("mileage")
    private Integer mileage;

    @SerializedName("color")
    private String color;

    public DateTime getDate() {
        return date;
    }

    public void setDate(final DateTime date) {
        this.date = date;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(final Integer mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "InfoDto{" +
                "date=" + date +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                '}';
    }
}
