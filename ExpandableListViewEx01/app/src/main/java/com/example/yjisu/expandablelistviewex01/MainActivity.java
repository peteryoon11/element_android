package com.example.yjisu.expandablelistviewex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arrProv = new String[] { "충청", "경기도", "강원도" };
        String[][] arrCity = new String[][] {
                { "논산", "당진", "부여" },
                { "수원", "용인" },
                { "춘천", "원주", "홍천", "강릉" }
        };

        List<Map<String, String>> provData = new ArrayList<>();
        List<List<Map<String, String>>> cityData = new ArrayList<>();

        for(int i=0 ; i<arrProv.length ; i++) {
            Map<String, String> prov = new HashMap<>();
            prov.put("prov", arrProv[i]);
            provData.add(prov);

            List<Map<String, String>> cities = new ArrayList<>();
            for(int j=0 ; j<arrCity[i].length ; j++) {
                Map<String, String> city = new HashMap<>();
                city.put("city", arrCity[i][j]);
                cities.add(city);
            }
            cityData.add(cities);
        }

        ExpandableListAdapter adapter
                = new SimpleExpandableListAdapter(this,

                provData, android.R.layout.simple_expandable_list_item_1,
                new String[] { "prov" }, new int[] { android.R.id.text1 },

                cityData, android.R.layout.simple_expandable_list_item_1,
                new String[] { "city" }, new int[] { android.R.id.text1 });

        ExpandableListView expandableListView
                = (ExpandableListView)findViewById(R.id.expandableListView);
        expandableListView.setAdapter(adapter);
    }
}
