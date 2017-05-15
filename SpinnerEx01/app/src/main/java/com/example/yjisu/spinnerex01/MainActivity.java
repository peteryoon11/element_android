package com.example.yjisu.spinnerex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
boolean flag= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> datas=new ArrayList<>();

        datas.add("사과");
        datas.add("딸기");
        datas.add("수박");
        datas.add("사과1");
        datas.add("사과2");

        ArrayAdapter<String > adapter = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_dropdown_item,datas);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner= (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setPrompt("과일선택 ");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // 자동으로 초기 선택이 됨
                // 스피너가 보이면서 자동 초기 선택 이 됨
                // 자동 초기선택을 막아주는 기능임
             /*   if(flag==false)
               {
                   flag=true;
                   return;
               }*/
              //  Toast.makeText(MainActivity.this,position, Toast.LENGTH_SHORT).show();

                System.out.println("onItemSelectd");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
