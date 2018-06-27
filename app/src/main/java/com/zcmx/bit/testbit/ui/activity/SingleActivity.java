package com.zcmx.bit.testbit.ui.activity;

import com.zcmx.bit.testbit.R;
import com.zcmx.bit.testbit.core.cicerone.MainNavigator;
import com.zcmx.bit.testbit.core.di.DI;
import com.zcmx.bit.testbit.viewmodel.StartViewModel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;

public class SingleActivity extends AppCompatActivity {

    @Inject
    protected NavigatorHolder navigatorHolder;

    private Navigator navigator;

    private StartViewModel startViewModel;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        DI.getComponentManager().getUserComponent().inject(this);

        navigator = new MainNavigator(this, R.id.container);

        startViewModel = ViewModelProviders.of(this).get(StartViewModel.class);

        startViewModel.openStartScreen();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }
}
