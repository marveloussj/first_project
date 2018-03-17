package com.sj.netease.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.sj.netease.R;
import com.sj.netease.news.adapter.NewsAdapter;
import com.sj.netease.news.bean.FragmentInfo;
import com.sj.netease.news.inner_fragment.Hotfragment;

import java.util.ArrayList;

/**
 * Created by sj on 2017/8/27.
 */

public class NewsFragment extends Fragment {
    ArrayList<FragmentInfo> mfragment;
    NewsAdapter mNewsAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FrameLayout layout = getActivity().findViewById(R.id.tabs);
        layout.addView(View.inflate(getActivity(),R.layout.include_tab,null));
        ViewPager viewPager = getActivity().findViewById(R.id.viewpager);
        SmartTabLayout smartTabLayout = getActivity().findViewById(R.id.smart_tab);
        String[] array = getResources().getStringArray(R.array.news_titles);
        mfragment=new ArrayList<>();
        for (int i=0;i<array.length;i++){
            FragmentInfo info;
            if(i==0){
                Log.i("sj","HotFragment");
            info=new FragmentInfo(new Hotfragment(),array[i]);
            }else{
                info=new FragmentInfo(new ReadingFragment(),array[i]);
            }
            mfragment.add(info);
        }
        mNewsAdapter=new NewsAdapter(getFragmentManager(),mfragment);
    viewPager.setAdapter(mNewsAdapter);
        smartTabLayout.setViewPager(viewPager);


    }
}
