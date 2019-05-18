package com.rrokullia.pluscomputers.mosque.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rrokullia.pluscomputers.mosque.fragments.Fragment1;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment1 frag1 = Fragment1.newInstance();
                return frag1;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
