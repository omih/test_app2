package com.zcmx.bit.data.storage.dao;

import com.zcmx.bit.data.model.entity.AuthorizationEntity;
import com.zcmx.bit.data.storage.Tables;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

@Dao
public interface AuthDao extends BaseDao<AuthorizationEntity> {

    @Query("select * from " + Tables.AUTH)
    AuthorizationEntity getAuth();
}
