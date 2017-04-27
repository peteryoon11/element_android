package com.example.yjisu.checkboxex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CheckBox checkBox1=(CheckBox)findViewById(R.id.checkBox1);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView textView=(TextView)findViewById(R.id.textView);
            textView.setText(isChecked+"");
            }
        });
        /*

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=(TextView)findViewById(R.id.textView);
                if(checkBox1.isChecked())
                {
                    textView.setText(checkBox1.getText());

                }
                else
                {
                    textView.setText("");

                }
            }
        });
*/

        /*`
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox1=(CheckBox)findViewById(R.id.checkBox1);
// 다중선택 if 만 사용함
                CheckBox checkBox2=(CheckBox)findViewById(R.id.checkBox2);
                CheckBox checkBox3=(CheckBox)findViewById(R.id.checkBox3);
                TextView textView=(TextView)findViewById(R.id.textView);
                textView.setText("");
                if(checkBox1.isChecked())
                {
                    textView.append(checkBox1.getText()+"\n");
                }
                if(checkBox2.isChecked())
                {
                    textView.append(checkBox2.getText()+"\n");
                }
                if(checkBox3.isChecked())
                {
                    textView.append(checkBox3.getText()+"\n");
                }
            }

        });*/
    }
}
