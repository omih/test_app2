package com.zcmx.bit.data.storage.dao;

import com.zcmx.bit.data.model.entity.UserEntity;
import com.zcmx.bit.data.storage.Tables;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao extends BaseDao<UserEntity> {

    @Query("SELECT * FROM " + Tables.USER)
    List<UserEntity> getUsers();
}
