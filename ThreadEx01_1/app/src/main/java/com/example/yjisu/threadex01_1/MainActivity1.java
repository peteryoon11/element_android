package com.example.yjisu.threadex01_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity1 extends AppCompatActivity {

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


        BackThred thread = new BackThred();
        thread.setDaemon(true);
        thread.start();


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainValue++;
                backValue++;
                textView1.setText("MainValue : "+mainValue);

                textView2.setText("BackValue : "+backValue);
            }
        });



    }
    class BackThred extends Thread
    {
        // 병렬적으로 수행될일을 기록


        @Override
        public void run() {
            super.run();
            while (true)
            {
                backValue++;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

