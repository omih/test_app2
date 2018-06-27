package com.zcmx.bit.testbit.core.di;

import android.content.Context;

public class DI {

    private DI() {
    }

    private static ComponentManager componentManager;

    public static void init(Context context) {
        componentManager = new ComponentManager(context);
    }

    public static ComponentManager getComponentManager() {
        return componentManager;
    }
}
