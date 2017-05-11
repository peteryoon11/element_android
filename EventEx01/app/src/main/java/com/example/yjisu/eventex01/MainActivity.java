package com.example.yjisu.eventex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. 익명 내부 클래스 이용법
        /*
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"button1",Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"button2",Toast.LENGTH_SHORT).show();

            }
        });*/
        findViewById(R.id.button1).setOnClickListener(customClickListner);

        findViewById(R.id.button2).setOnClickListener(customClickListner);


    }
/*
    class CustomClickListner implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {

            Button button=(Button)v;
            Toast.makeText(MainActivity.this,"button : "+button.getText(),Toast.LENGTH_SHORT).show();
        }
    }
    CustomClickListner customClickListner=new CustomClickListner();*/

View.OnClickListener customClickListner = new View.OnClickListener()
{
    @Override
    public void onClick(View v) {

        Button button=(Button)v;
        Toast.makeText(MainActivity.this,"button : "+button.getText(),Toast.LENGTH_SHORT).show();
    }
};


}
