package com.example.user.networkex02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                try {
                    String getURL = "https://www.naver.com/index.html";
                    URL url = new URL(getURL);
                    conn = (HttpURLConnection)url.openConnection();
                    if(conn != null) {
                        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                            String line = null;
                            while((line = br.readLine()) != null) {
                                System.out.println(line + "\n");
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(br != null) try { br.close(); } catch (IOException e) {}
                    if(conn != null) conn.disconnect();
                }
            }
        });
        thread.start();
    }
}
