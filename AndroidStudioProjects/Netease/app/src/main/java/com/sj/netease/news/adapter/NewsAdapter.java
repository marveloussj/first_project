package com.sj.netease.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sj.netease.news.bean.FragmentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sj on 2017/8/30.
 */

public class NewsAdapter extends FragmentStatePagerAdapter{
    ArrayList<FragmentInfo> mFragments;
    public NewsAdapter(FragmentManager fm,ArrayList<FragmentInfo> fragments) {
        super(fm);
        this.mFragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position).getmFragment();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }
}
