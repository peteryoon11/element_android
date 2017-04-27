package com.example.yjisu.alertdialogueex01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {/*
                Dialog dialog=new Dialog(MainActivity.this);
                TextView textView=new TextView(MainActivity.this);

                textView.setText("대화상자 내용");
                dialog.setContentView(textView);
                dialog.setTitle("title!!!");
                dialog.show();*/

            /*AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("타이틀");
                builder.setMessage("내용");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.show();
*/
  new AlertDialog.Builder(MainActivity.this)
               // new AlertDialog.Builder(MainActivity.this)
                        .setTitle("타이틀")
                        .setMessage("내용")
                .setIcon(R.mipmap.ic_launcher)
          .setPositiveButton("확인", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  Toast.makeText(MainActivity.this,"확인",Toast.LENGTH_SHORT);
              }
          })
          .setNegativeButton("취소",null)
          .setNeutralButton("중간",null)
          .show();

        /*                .setPosttivButton()
                        .setNeu
        */  /*      .show();
*/
            }
        });
    }
}
