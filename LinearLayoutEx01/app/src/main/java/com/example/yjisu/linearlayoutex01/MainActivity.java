package com.example.yjisu.linearlayoutex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 순서가 있음
        Button button1= (Button)findViewById(R.id.button1);

        button1.setText("난 버튼");
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                System.out.println("dddd");
             //   Toast.makeText(MainActivity.this,"버튼 클릭",Toast.LENGTH_SHORT).show();
            }


        });

    }
}
