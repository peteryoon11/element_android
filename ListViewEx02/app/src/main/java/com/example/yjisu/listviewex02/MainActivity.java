package com.example.yjisu.listviewex02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<HashMap<String,String>> datas =
                new ArrayList<>();
        HashMap<String,String> data1= new HashMap<>();
        HashMap<String,String> data2= new HashMap<>();
        HashMap<String,String> data3= new HashMap<>();
        HashMap<String,String> data4= new HashMap<>();
        data1.put("v1","을지문덕 ");
        data1.put("v2","고구려 ");


        data2.put("v1","김유신 ");
        data2.put("v2","신라 ");

        data3.put("v1","백제인물 ");
        data3.put("v2","백제 ");

        data4.put("v1","조선인물 ");
        data4.put("v2","조선 ");

        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);

        SimpleAdapter adapter=new SimpleAdapter(
                this,
                datas,
                android.R.layout.simple_list_item_2,
                new String[]{"v1","v2"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );

        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);




    }
}
