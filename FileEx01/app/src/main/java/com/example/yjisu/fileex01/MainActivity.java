package com.example.yjisu.fileex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BufferedWriter bw=null;
                try {

                    bw = new BufferedWriter(new OutputStreamWriter(openFileOutput("test.txt", MODE_APPEND)));
                    // MODE_PRIVATE 는 덮어 쓰기
                    // MODE_APPEND 는 추가로 붙여 넣기가 됨
                    bw.write("Hello File 1\n");
                    bw.write("Hello File 2\n");
                    bw.write("Hello File 3\n");
                    bw.write("한글 한글 \n");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                finally {
                    if(bw!=null)
                    {
                        try{
                            bw.close();
                        }
                        catch (IOException e)
                        {

                        }
                    }
                }

                    Toast.makeText(MainActivity.this,"저장 완료",Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=(TextView)findViewById(R.id.textView);
                textView.setText("");
                BufferedReader br= null;
                try {
                    br = new BufferedReader(new InputStreamReader(openFileInput("test.txt")));
                    String data = "";
                    while ((data = br.readLine()) != null) {
                        textView.append(data + "\n");
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                finally {
                    if(br!=null)
                    {
                     try
                     {
                         br.close();
                     }
                     catch (IOException e)
                     {

                     }
                    }
                }

            }
        });
    }
}
