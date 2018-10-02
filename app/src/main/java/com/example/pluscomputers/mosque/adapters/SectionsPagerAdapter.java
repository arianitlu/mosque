package com.example.pluscomputers.mosque.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pluscomputers.mosque.fragments.Fragment1;
import com.example.pluscomputers.mosque.fragments.Fragment2;
import com.example.pluscomputers.mosque.fragments.Fragment3;
import com.example.pluscomputers.mosque.fragments.Fragment4;
import com.example.pluscomputers.mosque.fragments.Fragment5;
import com.example.pluscomputers.mosque.fragments.Fragment6;

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
            case 1:
                Fragment2 frag2 = Fragment2.newInstance();
                return frag2;
            case 2:
                Fragment3 frag3 = Fragment3.newInstance();
                return frag3;
            case 3:
                Fragment4 frag4 = Fragment4.newInstance();
                return frag4;
            case 4:
                Fragment5 frag5 = Fragment5.newInstance();
                return frag5;
            case 5:
                Fragment6 frag6 = Fragment6.newInstance();
                return frag6;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }
}
