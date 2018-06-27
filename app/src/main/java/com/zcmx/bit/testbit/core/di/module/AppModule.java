package com.zcmx.bit.testbit.core.di.module;

import com.zcmx.bit.data.network.ClientFactory;
import com.zcmx.bit.data.network.api.Api;
import com.zcmx.bit.data.network.api.ApiFactory;
import com.zcmx.bit.data.scheduler.AppSchedulerProvider;
import com.zcmx.bit.data.scheduler.SchedulerProvider;
import com.zcmx.bit.data.storage.MainDatabase;
import com.zcmx.bit.testbit.core.di.scope.AppScope;

import android.arch.persistence.room.Room;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(final Context context) {
        this.context = context;
    }

    @Provides
    @AppScope
    public Context provideContext() {
        return context;
    }

    @Provides
    @AppScope
    public MainDatabase provideDatabase() {
        return Room.databaseBuilder(context, MainDatabase.class, MainDatabase.DB_NAME).build();
    }

    @Provides
    @AppScope
    public Api provideApi(ClientFactory clientFactory) {
        return new ApiFactory(clientFactory).access;
    }

    @Provides
    @AppScope
    public ClientFactory provideNetworkClient() {
        return new ClientFactory();
    }

    @Provides
    @AppScope
    public SchedulerProvider provideRxSchedulers() {
        return new AppSchedulerProvider();
    }
}
