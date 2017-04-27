package com.example.yjisu.userregivaldate_sol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private InputMethodManager inputMethodManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Button button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        findViewById(R.id.editText1).setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                boolean result=false;
                
                EditText editText=(EditText)findViewById(R.id.editText1);

                int re_length=editText.getText().length();

                System.out.println(re_length+" 현재 길이 editText 1 ");

                if(re_length==6)
                {
                    Toast.makeText(MainActivity.this,"6자리 맞음",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(MainActivity.this," ed1 길이가 모자르거나 넘쳐요!",Toast.LENGTH_SHORT).show();

                }
//                Toast.makeText(MainActivity.this,"ㅇㅇㅇ",Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        findViewById(R.id.editText2).setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                boolean result=false;
                EditText editText=(EditText)findViewById(R.id.editText2);

                int re_length=editText.getText().length();
                System.out.println(re_length+" 현재 길이 editText2 ");
                System.out.println(Toast.LENGTH_SHORT+"  길이? ");

                if(re_length==7)
                {
                    Toast.makeText(MainActivity.this,"7자리 맞음",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(MainActivity.this," ed2 길이가 모자르거나 넘쳐요!",Toast.LENGTH_SHORT).show();

                }
//                Toast.makeText(MainActivity.this,"ㅇㅇㅇ",Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1=(EditText)findViewById(R.id.editText1);
                EditText editText2=(EditText)findViewById(R.id.editText2);
                TextView textView=(TextView)findViewById(R.id.textView);
                inputMethodManager.hideSoftInputFromWindow(editText1.getWindowToken(),0);
                inputMethodManager.hideSoftInputFromWindow(editText2.getWindowToken(),0);
                String strJumin=editText1.getText().toString()+editText2.getText().toString();

                System.out.println("입력 데이터 "+strJumin);
                int [] bits={2,3,4,5,6,7,8,9,2,3,4,5};
                int sum=0;

                for (int i=0;i<bits.length;i++){
                    sum+=Integer.parseInt(strJumin.substring(i,i+1))*bits[i];

                };
                int lastnum=Integer.parseInt(strJumin.substring(12,13));
                int result=(11-(sum%11))%10;
                TextView textView1=(TextView)findViewById(R.id.textView);

                if(lastnum==result)
                {
                    textView1.setText("주민 번호가 맞음");
                }
                else
                {

                    textView1.setText("주민 번호가 틀림");
                }
            }
        });
    }
}
