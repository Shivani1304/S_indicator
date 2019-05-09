package com.sindicator.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Shivani on 1/29/2017.
 */

public class HotelTab extends FragmentPagerAdapter {
    public HotelTab(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fivestar();
            case 1:
                return new Fourstar();
            case 2:
                return new Threestar();
            case 3:
                return new Twostar();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
