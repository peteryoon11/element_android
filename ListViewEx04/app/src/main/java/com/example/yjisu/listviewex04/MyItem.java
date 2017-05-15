package com.example.yjisu.listviewex04;

/**
 * Created by yjisu on 2017-05-11.
 */

public class MyItem {
    private int icon;
    private String name;

    public MyItem(int icon, String name) {
        this.icon = icon;
        this.name = name;
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
