package com.zcmx.bit.data.storage.converter;

import org.joda.time.DateTime;

import android.arch.persistence.room.TypeConverter;

public class DateTimeConverter {

    @TypeConverter
    public Long fromDateTime(DateTime dateTime) {
        return dateTime.toDateTime().getMillis();
    }

    @TypeConverter
    public DateTime toDateTime(Long millis) {
        DateTime dateTime = null;
        if (millis != null) {
            dateTime = new DateTime(millis);
        }
        return dateTime;
    }

}
