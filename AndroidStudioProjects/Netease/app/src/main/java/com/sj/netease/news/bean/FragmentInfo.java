package com.sj.netease.news.bean;

import android.support.v4.app.Fragment;

/**
 * Created by sj on 2017/8/30.
 */

public class FragmentInfo {
    Fragment mFragment;
    String title;

    public FragmentInfo(Fragment mFragment, String title) {
        this.mFragment = mFragment;
        this.title = title;
    }

    public Fragment getmFragment() {
        return mFragment;
    }

    public void setmFragment(Fragment mFragment) {
        this.mFragment = mFragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "FragmentInfo{" +
                "mFragment=" + mFragment +
                ", title='" + title + '\'' +
                '}';
    }
}
