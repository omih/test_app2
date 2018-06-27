package com.zcmx.bit.data.storage.dao;

import com.zcmx.bit.data.model.entity.CarEntity;
import com.zcmx.bit.data.storage.Tables;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CarDao extends BaseDao<CarEntity> {

    @Query("SELECT * FROM " + Tables.CAR)
    List<CarEntity> getCars();
}
