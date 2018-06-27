package com.zcmx.bit.data.converter;

import com.zcmx.bit.data.model.entity.UserWithCarEntity;
import com.zcmx.bit.model.model.UserWithCar;

public class UserWithCarConverter {

    public static UserWithCar toModel(UserWithCarEntity entity) {
        return new UserWithCar(entity.id, entity.name, entity.carId, entity.nameCar, entity.date, entity.mileage, entity.colorCar);
    }
}
