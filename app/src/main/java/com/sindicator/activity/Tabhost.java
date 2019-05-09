package com.sindicator.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sony on 22-01-2017.
 */
public class Tabhost extends FragmentPagerAdapter {


    public Tabhost(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Government();
            case 1:
                return new Private1();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
