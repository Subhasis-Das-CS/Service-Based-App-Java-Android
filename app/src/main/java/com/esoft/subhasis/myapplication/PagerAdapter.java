package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabsNumber;
    public PagerAdapter(@NonNull FragmentManager fm,int behaviour, int tabs) {

        super(fm, behaviour);
        this.tabsNumber=tabs;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return new firstFragment();
            case 1: return new SecondFragment();
            case 2: return new ThirdFragment();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
