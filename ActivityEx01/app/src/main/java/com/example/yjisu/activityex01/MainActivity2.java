package com.example.yjisu.activityex01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yjisu on 2017-05-16...
 */

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent
                = getIntent();

        String data1=intent.getStringExtra("data1");
        String data2=intent.getStringExtra("data2");
        TextView textView=(TextView)findViewById(R.id.textView2);
        textView.append("data1 : "+data1 +" data2 : "+data2+" \n ");
        textView.append("data1 : "+data1 +" data2 : "+data2);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /*
               // 화면을 쌓는 개념
               Intent intent=new Intent(MainActivity2.this,MainActivity1.class);
                //     Intent intent=new Intent(MainActivity1.this,MainActivity3.class);
                startActivity(intent);*/

               // 화면을 메모리에서 제거 하는 부분

                Intent rintent = new Intent();

                rintent.putExtra("data1","back 박문수");
                rintent.putExtra("data2","back 홍길동");

                // REsult_OK 는 정상수행 을 알려주는 상수

                setResult(RESULT_OK,rintent);

               finish();
            }
        });
    }

/*
    // 끝나면서 자동 호출
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
   //     super.onActivityResult(requestCode, resultCode, data);
        System.out.print("dfdfdfdf =>");
switch (requestCode)
{
    case 0:
        if(resultCode==RESULT_OK)
        {
            String data1=data.getStringExtra("data1");
            String data2=data.getStringExtra("data2");
            Toast.makeText(this,data1+" \t "+data2 ,Toast.LENGTH_SHORT).show();
            System.out.print("dfdfdfdf");
        }
        break;
    default:
        break;
}
    }*/
}
