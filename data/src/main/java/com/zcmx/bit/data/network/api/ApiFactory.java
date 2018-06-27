package com.zcmx.bit.data.network.api;

import com.zcmx.bit.data.BuildConfig;
import com.zcmx.bit.data.network.ClientFactory;
import com.zcmx.bit.data.network.GsonFactory;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private ClientFactory clientFactory;

    public final Api access;

    @Inject
    public ApiFactory(ClientFactory factory) {
        clientFactory = factory;
        access = create(Api.class);
    }

    private <T> T create(Class<T> clazz) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER)
                .client(clientFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonFactory.networkGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(clazz);
    }
}
