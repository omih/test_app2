package com.zcmx.bit.data.network.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.joda.time.DateTime;

import java.lang.reflect.Type;

public class IsoDateTimeDeserializer implements JsonDeserializer<DateTime> {

    @Override
    public DateTime deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
        return new DateTime(json.getAsJsonPrimitive().getAsLong());
    }
}
