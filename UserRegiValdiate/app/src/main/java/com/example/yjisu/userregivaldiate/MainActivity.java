package com.example.yjisu.userregivaldiate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    Button button;
    TextView textView;
    InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=(EditText)findViewById(R.id.editText1);
       editText2=(EditText)findViewById(R.id.editText2);
        button=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.edit_text_bottom);
        button.setText("난 버튼");
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                char[] totalText= (String.valueOf(editText1.getText())+String.valueOf(editText2.getText())).toCharArray();
                char [] Valuekey="234567892345".toCharArray();
               // char [] resultTemp=new char[Valuekey.length];
                int temp=0;
                System.out.println("totalText 길이 " +totalText.length);
                for (int i=0;i<Valuekey.length;i++)
                {
                  System.out.println(Valuekey[i]+"\t"+i);
                    temp+=Integer.parseInt(String.valueOf(Valuekey[i])) * Integer.parseInt(String.valueOf(totalText[i]));
                };
                System.out.println("temp = "+temp+"");
                //int result=(((temp%11)%11)%10);
                int result=((11-(temp%11))%10);
                System.out.println("result = "+result+"");
                if(result==5)
                {
                    textView.setText("유효한 번호!");
                }
                else
                {
                    textView.setText("유효하지 않은 번호!");

                }
                //   Toast.makeText(MainActivity.this,"버튼 클릭",Toast.LENGTH_SHORT).show();

            }


        });

    }
}
