package com.zcmx.bit.data.storage;

import com.zcmx.bit.data.model.entity.AuthorizationEntity;
import com.zcmx.bit.data.model.entity.CarEntity;
import com.zcmx.bit.data.model.entity.UserEntity;
import com.zcmx.bit.data.storage.converter.DateTimeConverter;
import com.zcmx.bit.data.storage.dao.AuthDao;
import com.zcmx.bit.data.storage.dao.CarDao;
import com.zcmx.bit.data.storage.dao.UserDao;
import com.zcmx.bit.data.storage.dao.UserWithCarDao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

@Database(entities = {
        CarEntity.class,
        UserEntity.class,
        AuthorizationEntity.class
}, version = 1)
@TypeConverters(DateTimeConverter.class)
abstract public class MainDatabase extends RoomDatabase {

    public static final String DB_NAME = "db_name";

    abstract public UserDao getUserDao();

    abstract public CarDao getCarDao();

    abstract public UserWithCarDao getUsersWithCarDao();

    abstract public AuthDao getAuthDao();
}
