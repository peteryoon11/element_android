package com.example.yjisu.threadex02;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Handler handler= new Handler();
        // postDelayed 일정 시간 ms 후에 스레드 실행!!
        // 스프레시 스크린
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            //    Toast.makeText(MainActivity1.this,"실행! ",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity1.this,MainActivity2.class);
                startActivity(intent);
                finish();
            }
        },5000);

      /*  findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
}
