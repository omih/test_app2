package com.zcmx.bit.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.zcmx.bit.data.network.deserializer.IsoDateTimeDeserializer;

import org.joda.time.DateTime;

public class GsonFactory {

    public final static Gson networkGson;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(DateTime.class, new IsoDateTimeDeserializer());
        networkGson = builder.create();
    }

    private GsonFactory() {
    }


}
