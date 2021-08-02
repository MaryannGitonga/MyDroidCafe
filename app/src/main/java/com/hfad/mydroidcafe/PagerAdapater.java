package com.hfad.mydroidcafe;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapater extends FragmentStatePagerAdapter {

    int myNumOfTabs;

    public PagerAdapater(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm, numOfTabs);
        this.myNumOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DessertRecipeFragment();
            case 1:
                return new PastriesRecipeFragment();
            case 2:
                return new StoresFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return myNumOfTabs;
    }
}
