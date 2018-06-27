package com.zcmx.bit.testbit.core.di.module;

import com.zcmx.bit.testbit.core.di.scope.AppScope;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class NavigationModule {

    private Cicerone<Router> cicerone = Cicerone.create();

    @Provides
    @AppScope
    public Router provideAppRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @AppScope
    public NavigatorHolder provideNavigationHolder() {
        return cicerone.getNavigatorHolder();
    }
}
