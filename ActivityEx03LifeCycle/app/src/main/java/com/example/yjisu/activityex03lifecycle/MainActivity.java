package com.example.yjisu.activityex03lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate 호출 ");


    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart 호출 ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart 호출 ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume 호출 ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause 호출 ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop 호출 ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy 호출 ");
    }
}
