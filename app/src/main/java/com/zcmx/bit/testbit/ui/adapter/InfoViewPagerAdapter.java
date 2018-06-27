package com.zcmx.bit.testbit.ui.adapter;

import com.zcmx.bit.testbit.R;
import com.zcmx.bit.testbit.ui.fragment.ListFragment;
import com.zcmx.bit.testbit.ui.fragment.MapFragment;

import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class InfoViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    private List<String> title = new ArrayList<>();

    public InfoViewPagerAdapter(final FragmentManager fragmentManager, Resources resources) {
        super(fragmentManager);

        fragments.add(MapFragment.newInstance());
        fragments.add(ListFragment.newInstance());

        title.add(resources.getString(R.string.map));
        title.add(resources.getString(R.string.list));
    }

    @Override
    public Fragment getItem(final int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(final int position) {
        return title.get(position);
    }
}
