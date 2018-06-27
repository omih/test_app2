package com.zcmx.bit.testbit;

import com.zcmx.bit.testbit.core.di.DI;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        buildDependencyGraph();
    }

    public static Context getContext() {
        return context;
    }

    private void buildDependencyGraph() {
        DI.init(context);
        DI.getComponentManager().getAppComponent().inject(this);
    }
}
