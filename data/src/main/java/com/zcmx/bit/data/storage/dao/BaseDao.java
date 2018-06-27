package com.zcmx.bit.data.storage.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

public interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(T obj);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<T> obj);

    @Delete
    void delete(T obj);
}
