package com.example.yjisu.postnumberfinder;

/**
 * Created by yjisu on 2017-05-11.
 */

public class MyItem {
    private int icon;
    private String name;
    private  String postnum;

    public MyItem(int icon, String name,String postnum) {
        this.icon = icon;
        this.name = name;
        this.postnum=postnum;
    }

    public String getPostnum() {
        return postnum;
    }

    public void setPostnum(String postnum) {
        this.postnum = postnum;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
