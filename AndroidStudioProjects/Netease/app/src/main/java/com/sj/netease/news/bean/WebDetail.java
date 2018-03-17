package com.sj.netease.news.bean;

import java.util.List;

/**
 * Created by sj on 2017/9/21.
 */

public class WebDetail {
    String body;
    //重大错误，在javabean中必须使用对应的键值对名称进行封装，应该把webimg改为img!!!!
    List<WebDetailImag> webimg;
    String title;
    String source;
    String ptime;

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    int replyCount;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<WebDetailImag> getWebimg() {
        return webimg;
    }

    public void setWebimg(List<WebDetailImag> webimg) {
        this.webimg = webimg;
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

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    @Override
    public String toString() {
        return "WebDetail{" +
                "body='" + body + '\'' +
                ", webimg=" + webimg +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", ptime='" + ptime + '\'' +
                '}';
    }
}
