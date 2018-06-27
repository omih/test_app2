package com.zcmx.bit.data.model.entity;

import com.zcmx.bit.data.storage.Tables;

import org.joda.time.DateTime;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = Tables.CAR)
public class CarEntity {

    @PrimaryKey
    public Long id;

    public String name;

    public DateTime date;

    public Integer mileage;

    public String color;

    public CarEntity() {
    }

    @Ignore
    public CarEntity(final Long id, final String name, final DateTime date, final Integer mileage, final String color) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.mileage = mileage;
        this.color = color;
    }
}
