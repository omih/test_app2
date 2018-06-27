package com.zcmx.bit.data.model.entity;

import com.zcmx.bit.data.storage.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = Tables.USER)
public class UserEntity {

    @PrimaryKey
    public Long id;

    public String name;

    public Long carId;

    public UserEntity() {
    }

    @Ignore
    public UserEntity(final Long id, final String name, final Long carId) {
        this.id = id;
        this.name = name;
        this.carId = carId;
    }
}
