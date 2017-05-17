package com.example.yjisu.activityex01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 두 액티비티 연결 통로
              Intent intent=new Intent(MainActivity1.this,MainActivity2.class);
                //     Intent intent=new Intent(MainActivity1.this,MainActivity3.class);
                intent.putExtra("data1","홍길동");
                intent.putExtra("data2","박문수");

                //startActivity(intent);
// 결과 있는 것을 받을거야
                // 0 : 보여질 activiy 의 구분자 상수 자식에게 매기는 식별 번호
                startActivityForResult(intent,0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //     super.onActivityResult(requestCode, resultCode, data);
        System.out.println("dfdfdfdf =>");
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
    }
}
