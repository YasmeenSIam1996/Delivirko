package com.ict.delivirko.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.ict.delivirko.fragment.pilot.PlaceholderBackedFragment;

public class BackedOrdersPagerAdapter extends FragmentStatePagerAdapter {
    public int getCount() {
        return 4;
    }

    public BackedOrdersPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment getItem(int i) {
        return PlaceholderBackedFragment.newInstance("", "");
    }
}
