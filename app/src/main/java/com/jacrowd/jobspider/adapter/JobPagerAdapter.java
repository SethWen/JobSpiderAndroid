package com.jacrowd.jobspider.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author: Shawn
 * time  : 2017/7/8 21:57
 * desc  :
 */
public class JobPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public JobPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }



    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
