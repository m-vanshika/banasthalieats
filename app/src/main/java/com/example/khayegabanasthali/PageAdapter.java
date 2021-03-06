package com.example.khayegabanasthali;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm);
       this.mNumOfTabs=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
           case 0:
                return new snacks();
            case 1:
                return new main_c();
            case 2:
                return new dess();
            case 3:
                return new drink();

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
