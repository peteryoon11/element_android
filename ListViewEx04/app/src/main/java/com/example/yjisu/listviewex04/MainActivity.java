package com.example.yjisu.listviewex04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MyItem> myItems= new ArrayList<>();

        MyItem myItem1= new MyItem(R.mipmap.ic_launcher,"노트북 1 ");
        MyItem myItem2= new MyItem(R.mipmap.ic_launcher,"노트북 2 ");
        MyItem myItem3= new MyItem(R.mipmap.ic_launcher,"노트북 3 ");
        MyItem myItem4= new MyItem(R.mipmap.ic_launcher,"노트북 4 ");
        MyItem myItem5= new MyItem(R.mipmap.ic_launcher,"노트북 5 ");



        myItems.add(myItem1);
        myItems.add(myItem2);
        myItems.add(myItem3);
        myItems.add(myItem4);
        myItems.add(myItem5);
        myItems.add(myItem1);
        myItems.add(myItem2);
        myItems.add(myItem3);
        myItems.add(myItem4);
        myItems.add(myItem5);
        myItems.add(myItem1);
        myItems.add(myItem2);
        myItems.add(myItem3);
        myItems.add(myItem4);
        myItems.add(myItem5);



        MyListAdapter myListAdapter= new MyListAdapter(this, myItems);
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(myListAdapter);



    }
}
