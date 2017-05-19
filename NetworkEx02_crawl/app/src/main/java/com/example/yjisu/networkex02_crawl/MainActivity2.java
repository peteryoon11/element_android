package com.example.yjisu.networkex02_crawl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ANR 시간이 지나면
        // 네트워크 10초 지나면 죽음 그래서 thread 사용함
findViewById(R.id.basic).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        readServer();
    }
});

    }

    private  void  readServer()
    {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                HttpsURLConnection conn=null;
                BufferedReader bufferedReader = null;

                String geturl= "http://www,nave.com/index.html";
                try {
                    URL url= new URL(geturl);
                    conn=(HttpsURLConnection)url.openConnection();
                    if(conn!=null)
                    {
                        if(conn.getResponseCode()==HttpsURLConnection.HTTP_OK);
                        {
                            bufferedReader= new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
                            String line = null;
                            while ((line= bufferedReader.readLine())!=null)
                            {
                                System.out.println(line+"\n");
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    if(bufferedReader!=null)
                    {
                        try {
                            bufferedReader.close();
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if(conn!=null)
                    {
                        conn.disconnect();
                    }
                }


            }
        });

        thread.start();
    }
}
