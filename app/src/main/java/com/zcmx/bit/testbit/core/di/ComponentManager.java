package com.zcmx.bit.testbit.core.di;

import com.zcmx.bit.testbit.core.di.component.AppComponent;
import com.zcmx.bit.testbit.core.di.component.DaggerAppComponent;
import com.zcmx.bit.testbit.core.di.component.UserComponent;
import com.zcmx.bit.testbit.core.di.module.AppModule;
import com.zcmx.bit.testbit.core.di.module.UserModule;

import android.content.Context;

public class ComponentManager {

    private AppComponent appComponent;

    private UserComponent userComponent;

    public ComponentManager(final Context context) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(context))
                .build();

        userComponent = appComponent
                .userComponentBuilder()
                .userModule(new UserModule())
                .build();
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
