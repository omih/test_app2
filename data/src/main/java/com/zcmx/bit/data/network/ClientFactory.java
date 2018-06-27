package com.zcmx.bit.data.network;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import com.zcmx.bit.data.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class ClientFactory {

    private final static long CONNECT_TIMEOUT_MILLIS = 120000L;

    private final static long READ_TIMEOUT_MILLIS = 120000L;


    public OkHttpClient create() {
        return getPreconfiguredClientBuilder()
                .addInterceptor(getLoggingInterceptor())
                .build();
    }

    private OkHttpClient.Builder getPreconfiguredClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        builder.readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        return builder;
    }

    private LoggingInterceptor getLoggingInterceptor() {
        return new LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .request("Request")
                .response("Response")
                .build();
    }
}
