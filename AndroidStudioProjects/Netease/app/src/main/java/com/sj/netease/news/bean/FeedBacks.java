package com.sj.netease.news.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sj on 2017/10/2.
 */

public class FeedBacks {
    ArrayList<FeedBack> hot;

    boolean isTitle =false;
    String titleS ;

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public String getTitleS() {
        return titleS;
    }

    public void setTitleS(String titleS) {
        this.titleS = titleS;
    }

    public FeedBacks() {
        this.hot = new ArrayList<>();
    }
    public void sort(){
        Collections.sort(hot,new FeedBackSort());
    }
    class FeedBackSort implements Comparator{

        @Override
        public int compare(Object l, Object r) {
            if( ((FeedBack)l).getIndex()>((FeedBack)r).getIndex()){
                return 1;
            }else if(((FeedBack)l).getIndex()<((FeedBack)r).getIndex()){
                return -1;
            }else{
                return 0;
            }
        }
    }
    public FeedBack getLastPosition(){
        FeedBack feedBack = hot.get(hot.size() - 1);
        return feedBack;
    }
    public void add(FeedBack feedBack){
        hot.add(feedBack);
    }

    @Override
    public String toString() {
        return "FeedBacks{" +
                "hot=" + hot +
                '}';
    }
}
