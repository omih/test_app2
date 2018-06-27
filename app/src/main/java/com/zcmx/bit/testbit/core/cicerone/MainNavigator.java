package com.zcmx.bit.testbit.core.cicerone;

import com.zcmx.bit.testbit.ui.activity.SingleActivity;
import com.zcmx.bit.testbit.ui.fragment.AuthFragment;
import com.zcmx.bit.testbit.ui.fragment.CameraFragment;
import com.zcmx.bit.testbit.ui.fragment.InfoFragment;
import com.zcmx.bit.testbit.ui.fragment.PhotoGalleryFragment;

import android.support.v4.app.Fragment;

import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MainNavigator extends SupportFragmentNavigator {

    private final SingleActivity activity;

    public MainNavigator(final SingleActivity activity, final int containerId) {
        super(activity.getSupportFragmentManager(), containerId);

        this.activity = activity;
    }

    @Override
    protected Fragment createFragment(final String screenKey, final Object data) {
        Fragment fragment = null;
        switch (screenKey) {
            case Screen.INFO_SCREEN:
                fragment = InfoFragment.newInstance();
                break;
            case Screen.GALLERY_SCREEN:
                fragment = PhotoGalleryFragment.newInstance();
                break;
            case Screen.AUTH_SCREEN:
                fragment = AuthFragment.newInstance();
                break;
            case Screen.CAMERA_SCREEN:
                fragment = CameraFragment.newInstance();
                break;
            default:
                throw new IllegalArgumentException("Unknown screen " + screenKey);
        }
        return fragment;
    }

    @Override
    protected void showSystemMessage(final String message) {
    }

    @Override
    protected void exit() {
        activity.onBackPressed();
    }
}
