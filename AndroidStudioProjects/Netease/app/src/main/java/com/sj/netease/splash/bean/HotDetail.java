package com.sj.netease.splash.bean;

import java.util.List;

/**
 * Created by sj on 2017/9/5.
 */

public class HotDetail  {
    List<Banner> ads;
    String img;
    String title;
    String source;
    String id;
    int replyCount;
    public void setAds(List<Banner> ads) {
        this.ads = ads;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public List<Banner> getAds() {
        return ads;
    }

    public void setHot(List<Banner> ads) {
        this.ads = ads;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    @Override
    public String toString() {
        return "HotDetail{" +
                "ads=" + ads +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", id='" + id + '\'' +
                ", replyCount=" + replyCount +
                '}';
    }
}
