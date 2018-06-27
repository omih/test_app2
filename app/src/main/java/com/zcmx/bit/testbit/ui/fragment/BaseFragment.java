package com.zcmx.bit.testbit.ui.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

abstract public class BaseFragment extends Fragment {

    @Inject
    protected ViewModelProvider.Factory factory;
}
