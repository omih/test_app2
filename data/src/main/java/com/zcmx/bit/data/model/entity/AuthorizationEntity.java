package com.zcmx.bit.data.model.entity;

import com.zcmx.bit.data.storage.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = Tables.AUTH)
public class AuthorizationEntity {

    @PrimaryKey
    public Long id = 1L;

    public boolean skipAuth = false;

    public AuthorizationEntity() {
    }

    @Ignore
    public AuthorizationEntity(final boolean skipAuth) {
        this.skipAuth = skipAuth;
    }
}
