package com.zcmx.bit.testbit.ui.fragment;


import com.zcmx.bit.testbit.R;
import com.zcmx.bit.testbit.ui.adapter.InfoViewPagerAdapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InfoFragment extends BaseFragment {

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager pager = view.findViewById(R.id.view_pager);
        TabLayout tabs = view.findViewById(R.id.tabs);

        pager.setAdapter(new InfoViewPagerAdapter(getChildFragmentManager(), getResources()));
        tabs.setupWithViewPager(pager);
    }
}