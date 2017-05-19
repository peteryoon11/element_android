package com.example.yjisu.networkex01;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConnectivityManager connectivityManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectivityManager=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);

        // 네트워크에 뭐로 접속해 있는지 확인하는것!!










        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=(TextView)findViewById(R.id.textView);
                //textView.setText();

                // 전체 네트워크 상태 가져오기

             //   NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();
              /*  for(NetworkInfo  networkInfo :networkInfos)
                {
                    textView.append(networkInfo.toString()+"\n");
                }*/



              // 현재 접속된 네트워크

                NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
                textView.append(networkInfo.toString());
            //wifi 사용 여부
                boolean isWifiAvaliable
                        = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isAvailable();
                


            }
        });


    }
}
