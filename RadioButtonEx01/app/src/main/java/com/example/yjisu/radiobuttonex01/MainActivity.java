package com.example.yjisu.radiobuttonex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButton1=(RadioButton)findViewById(R.id.radioButton1);

                RadioButton radioButton2=(RadioButton)findViewById(R.id.radioButton2);

                RadioButton radioButton3=(RadioButton)findViewById(R.id.radioButton3);
                TextView textView=(TextView)findViewById(R.id.textView);
               /* textView.setText("");
               */
                if(radioButton1.isChecked())
                {
                    textView.append(radioButton1.getText()+"\n");
                }
                else if(radioButton2.isChecked())
                {
                    textView.append(radioButton2.getText()+"\n");
                }
                else if(radioButton3.isChecked())
                {
                    textView.append(radioButton3.getText()+"\n");
                }


            }
        });
    }
}
