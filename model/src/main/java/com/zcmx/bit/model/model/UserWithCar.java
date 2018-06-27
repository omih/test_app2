package com.zcmx.bit.model.model;

import org.joda.time.DateTime;

public class UserWithCar {

    private Long id;

    private String name;

    private Long carId;

    private String nameCar;

    private DateTime date;

    private Integer mileage;

    private String colorCar;

    public UserWithCar(final Long id, final String name, final Long carId, final String nameCar, final DateTime date, final Integer mileage,
            final String colorCar) {
        this.id = id;
        this.name = name;
        this.carId = carId;
        this.nameCar = nameCar;
        this.date = date;
        this.mileage = mileage;
        this.colorCar = colorCar;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCarId() {
        return carId;
    }

    public String getNameCar() {
        return nameCar;
    }

    public DateTime getDate() {
        return date;
    }

    public Integer getMileage() {
        return mileage;
    }

    public String getColorCar() {
        return colorCar;
    }
}
