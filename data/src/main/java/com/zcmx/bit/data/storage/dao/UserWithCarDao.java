package com.zcmx.bit.data.storage.dao;

import com.zcmx.bit.data.model.entity.UserWithCarEntity;
import com.zcmx.bit.data.storage.Tables;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserWithCarDao {

    @Query("select u.id, u.name, u.carId, c.name as nameCar, c.date, c.mileage, c.color as colorCar "
            + "from " + Tables.USER + " as u "
            + "inner join " + Tables.CAR + " as c "
            + "on u.carId = c.id")
    List<UserWithCarEntity> getUsersWithCar();
}
