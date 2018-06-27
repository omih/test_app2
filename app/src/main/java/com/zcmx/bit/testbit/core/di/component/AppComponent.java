package com.zcmx.bit.testbit.core.di.component;

import com.zcmx.bit.testbit.App;
import com.zcmx.bit.testbit.core.di.module.AppModule;
import com.zcmx.bit.testbit.core.di.module.NavigationModule;
import com.zcmx.bit.testbit.core.di.scope.AppScope;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, NavigationModule.class})
public interface AppComponent {

    void inject(App app);

    UserComponent.Builder userComponentBuilder();


}
