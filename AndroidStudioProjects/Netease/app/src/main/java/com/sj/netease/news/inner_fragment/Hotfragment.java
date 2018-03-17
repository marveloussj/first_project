package com.sj.netease.news.inner_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sj.netease.R;
import com.sj.netease.news.activity.DetailActivity;
import com.sj.netease.news.adapter.BannerAdapter;
import com.sj.netease.news.adapter.HotAdapter;
import com.sj.netease.splash.bean.Banner;
import com.sj.netease.splash.bean.Hot;
import com.sj.netease.splash.bean.HotDetail;
import com.sj.netease.util.Constant;
import com.sj.netease.util.HttpRespon;
import com.sj.netease.util.HttpUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by sj on 2017/8/30.
 */

public class Hotfragment extends Fragment implements ViewPager.OnPageChangeListener,AbsListView.OnScrollListener{
    ListView mListView;
    PtrClassicFrameLayout ptr;
    RelativeLayout loading;
    ArrayList<Banner> mBanner;
    ArrayList<HotDetail> mHotDetail;
    ArrayList<View> views;
    ArrayList<ImageView> dot_img;
    MyHandler myHandler;
    HotAdapter adapter;
    ViewPager viewPager;
    LayoutInflater inflater;
    BannerAdapter bannerAdapter;
    TextView mtitle;
    LinearLayout dots;
    static final int SUCCESS=0;
    static final int UPDATE_SUCESS=1;
    static final int STOP_RESH  =2;
    boolean isToEnd=false;
    boolean isHttpResquesting=false;
    int Strat=0;
    int End=0;
    int count=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot,container,false);
        mListView=  view.findViewById(R.id.listView);
       loading = view.findViewById(R.id.loading);
        ptr= view.findViewById(R.id.ptr);
        mListView.setEmptyView(loading);
        ptr.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            ptr.refreshComplete();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return super.checkCanDoRefresh(frame, mListView, header);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initCollection();
        initView();
        getDate(true);
    }

    private void initCollection() {
        mBanner=new ArrayList<>();
        mHotDetail=new ArrayList<>();
        views=new ArrayList<>();
        dot_img=new ArrayList<>();
    }

    private void initView() {
        myHandler=new MyHandler(this);
        inflater= LayoutInflater.from(getActivity());
        View head = inflater.inflate(R.layout.include_banner,null);
        mListView.addHeaderView(head);
        viewPager = head.findViewById(R.id.viewpager);
        viewPager.addOnPageChangeListener(this);
        mListView.setOnScrollListener(this);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), DetailActivity.class);
                HotDetail detail = adapter.getDateByIndex(position-mListView.getHeaderViewsCount());
                intent.putExtra(DetailActivity.DOCID,detail.getId());
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.activity_in,R.anim.activity_out);

            }
        });
        mtitle= head.findViewById(R.id.title);
        dots=head.findViewById(R.id.dots);
    }

    private void getDate(final boolean flag) {
        if(isHttpResquesting){
            return;
        }
        if(flag){
            count=0;
        }
        isHttpResquesting=true;
        HttpUtil util = HttpUtil.getInstance();
        callIndex();
        String newUrl = Constant.GetUrl(Strat, End);
        util.getDate(newUrl, new HttpRespon<Hot>(Hot.class) {

            @Override
            public void onError(String msg) {
                ptr.refreshComplete();
                isHttpResquesting=false;
            }

            @Override
            public void onSuccess(Hot hot) {
                myHandler.sendEmptyMessage(STOP_RESH);

                isHttpResquesting=false;
                if(hot!=null&&hot.getT1348647909107()!=null){
                    count++;
                    List<HotDetail> hotList = hot.getT1348647909107();
                    if(flag){
                        HotDetail banner = hotList.get(0);
                        List<Banner> banners = banner.getAds();
                        mBanner.addAll(banners);
                        hotList.remove(0);
                        mHotDetail.addAll(hotList);
                        myHandler.sendEmptyMessage(SUCCESS);
                    }else{
                        Message message = myHandler.obtainMessage(UPDATE_SUCESS);
                        message.obj=hotList;
                        myHandler.sendMessage(message);

                    }

                }
            }
        });
    }

    private void callIndex() {
        if(count==0){
            Strat=0;
            End=20;
        }else{
            Strat=End;
            End=Strat+20;
        }

    }
    public void stopResh(){
        ptr.refreshComplete();
    }
    public void initDate(){
        adapter=new HotAdapter(mHotDetail,getActivity());
        mListView.setAdapter(adapter);
    }
    public void upDate(List<HotDetail> newDate){
        if(adapter==null){
            mHotDetail= new ArrayList<>();
            mHotDetail.addAll(newDate);
            adapter=new HotAdapter(mHotDetail,getActivity());
            mListView.setAdapter(adapter);
        }else{
           adapter.addDate(newDate);
        }
    }
    public void initBanner(){
        dots.removeAllViews();
        dot_img.clear();
        views.clear();
        if(mBanner!=null&&mBanner.size()>0){
            for(int i=0;i<mBanner.size();i++){
                View view = inflater.inflate(R.layout.item_banner,null);
                views.add(view);
                ImageView dot=new ImageView(getActivity());
                dot.setImageResource(R.drawable.gray_dot);
                LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                p.setMargins(0,0,10,0);
                dots.addView(dot,p);
                dot_img.add(dot);

            }
            bannerAdapter= new BannerAdapter(views,mBanner);
            viewPager.setAdapter(bannerAdapter);
            int half=Integer.MAX_VALUE/2-(Integer.MAX_VALUE/2)%mBanner.size();
            viewPager.setCurrentItem(half);
            initImgDot(0);
            initTitle(0);
        }

    }
    public void initImgDot(int index){
    int size=dot_img.size();
        int realPosition =index%size;
        for (int i=0;i<size;i++){
            ImageView view = dot_img.get(i);
            if(i==realPosition){
                view.setImageResource(R.drawable.white_dot);
            }else{
                view.setImageResource(R.drawable.gray_dot);
            }
        }
    }
    public void initTitle(int index){
        int size=dot_img.size();
        int realPosition =index%size;
        mtitle.setText(mBanner.get(realPosition).getTitle());
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        initImgDot(position);
        initTitle(position);


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scroll) {
        if(scroll== SCROLL_STATE_IDLE&&isToEnd){
            getDate(false);
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int first, int i1, int total) {
        if(absListView.getLastVisiblePosition()==total-1){
            isToEnd=true;
        }else{
            isToEnd=false;
        }

    }

    static class MyHandler extends Handler{
        WeakReference<Hotfragment> fragment;
        public MyHandler(Hotfragment frament){
        this.fragment=new WeakReference(frament);
        }
        @Override
        public void handleMessage(Message msg) {
            Hotfragment hot = fragment.get();
            if(hot==null){
                return;
            }
            switch (msg.what){
                case SUCCESS:
                   hot.initDate();
                    hot.initBanner();
                     break;
                case UPDATE_SUCESS:
                    List<HotDetail> details = (List<HotDetail>) msg.obj;
                    hot.upDate(details);
                    break;
                case STOP_RESH:

                    hot.stopResh();
                    break;
            }
            super.handleMessage(msg);
        }
    }



}
