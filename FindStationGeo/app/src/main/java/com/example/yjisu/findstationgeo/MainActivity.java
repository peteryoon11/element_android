package com.example.yjisu.findstationgeo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private  String search_word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);


        // ANR - 네트워크 10초 - thread
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=(EditText)findViewById(R.id.editText);
               search_word=  editText.getText().toString();
           //     editText.setText("");

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


                String geoLat="";
                String geoLng="";

                StringBuffer result = new StringBuffer();
         /*       EditText editText=(EditText)findViewById(R.id.editText);
                editText.getText();*/

                try {
                  //  String station="서초역";
                    String station=search_word;
                    // String getURL = "https://www.naver.com/index.html";
                    String getURL = "https://maps.googleapis.com/maps/api/geocode/json?address="+station+"&language=ko";
                    URL url = new URL(getURL);
                    conn = (HttpURLConnection)url.openConnection();
                    if(conn != null) {
                        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                            String line = null;
                            int i=0;
                            while((line = br.readLine()) != null) {
                                    if(line.contains("location"))
                                    {
                                        i++;
                                        if(i==1)
                                        {
                                            geoLat=br.readLine();
                                            i++;
                                        }
                                        if(i==2)
                                        {
                                            geoLng=br.readLine();
                                        }
                                    }
                            //    result.append(line+"\n");
                                ///  System.out.println(line + "\n");
                              /*  if (line.contains("class=\"ah_k"))
                                {
                                    System.out.println(line+"\n");
                                }*/
                            }

                            result.append(geoLat+"\t"+geoLng);
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
                if(msg.obj!=null)
                {


                String [] datas=msg.obj.toString().split(" ");
                for(int i =0 ;i<datas.length; i++)
                {
                    System.out.println(datas[i]);
                }
                String templat=datas[2];
              //  String templat=datas[2];

                //   textView1.setText((StringBuffer)msg.obj);
                textView1.setText(templat);
                textView2.setText((StringBuffer)msg.obj);
                }
            }
        }
    };
}
