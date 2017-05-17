package com.example.yjisu.threadex01_1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    private  int mainValue=0;
    private  int backValue=0;
    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);


        BackRunnable runnable = new BackRunnable();

         Thread thread= new Thread(runnable);

        thread.setDaemon(true);
        thread.start();


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainValue++;
            //    backValue++;
                textView1.setText("MainValue : "+mainValue);

               // textView2.setText("BackValue : "+backValue);
            }
        });



    }
    class BackRunnable implements Runnable
    {
        @Override
        public void run() {

            while (true)
            {
                // 스레드 안에서는 화면의(GUI ) 접근이 안됨!!

                backValue++;
               // textView2.setText("BackValue : "+backValue);
// 이벤트 또는 통지!
                handler.sendEmptyMessage(0);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0)
            {
                textView2.setText("BackValue : "+backValue);
            }

        }
    };


}

