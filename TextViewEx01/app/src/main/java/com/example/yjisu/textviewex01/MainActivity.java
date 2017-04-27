package com.example.yjisu.textviewex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView1=(TextView)findViewById(R.id.textview1);
        final Button button1=(Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View v) {
                                      //     Toast.makeText(MainActivity.this,textView1.getText(),Toast.LENGTH_SHORT).show();
textView1.setText("바뀐 문자열 ");
                                       }
                                   }
        );
    }
}
