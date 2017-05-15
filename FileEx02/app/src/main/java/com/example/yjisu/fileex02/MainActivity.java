package com.example.yjisu.fileex02;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
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
                TextView textView=(TextView)findViewById(R.id.textView);
                textView.setText("");
                String state= Environment.getExternalStorageState();
                textView.append("SD 상태 : "+state+"\n");
          //      File file =Environment.getExternalStorageDirectory();
                File file =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                textView.append("경로 : "+file.toString()+ " 경로 : "+ file.getAbsolutePath());
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File file =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                BufferedWriter bw =null;
                // /storage/emulate/0/DCIM
                // = /sdcard/DCIM
try {


//    bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath() + "/test.txt")));
    bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath() + "/test.txt")));

    bw.write("Hello file1 \n");
    bw.write("Hello file2 \n");
    Toast.makeText(MainActivity.this,"입력 ㅇㅇ",Toast.LENGTH_SHORT).show();
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
e.printStackTrace();
        }
    }
}
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("");
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.test)));
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
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

    }
}
