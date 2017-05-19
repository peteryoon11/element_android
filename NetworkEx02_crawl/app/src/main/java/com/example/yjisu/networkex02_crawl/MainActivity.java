package com.example.yjisu.networkex02_crawl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);



        // ANR - 네트워크 10초 - thread
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readServer();
            }
        });
    }

    private void readServer() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn = null;
                BufferedReader br = null;

                StringBuffer result = new StringBuffer();


                try {
                    String station="서초역";
                   // String getURL = "https://www.naver.com/index.html";
                    String getURL = "https://maps.googleapis.com/maps/api/geocode/json?address="+station+"&language=ko";
                    URL url = new URL(getURL);
                    conn = (HttpURLConnection)url.openConnection();
                    if(conn != null) {
                        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                            String line = null;
                            while((line = br.readLine()) != null) {

                                result.append(line+"\n");
                      ///  System.out.println(line + "\n");
                              /*  if (line.contains("class=\"ah_k"))
                                {
                                    System.out.println(line+"\n");
                                }*/
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(br != null) try { br.close(); } catch (IOException e) {}
                    if(conn != null) conn.disconnect();
                }
                Message msg= Message.obtain();
                msg.what=100;
                msg.obj=result;
                handler.sendMessage(msg);
            }
        });
        thread.start();

    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //
            if(msg.what==100)
            {
                textView.setText((StringBuffer)msg.obj);
            }
        }
    };
}
