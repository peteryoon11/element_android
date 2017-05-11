package com.example.yjisu.eventex02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void doClick(View v)
    {
  /*      Button button=(Button)v;
        Toast.makeText(MainActivity.this,"button : "+ button.getText(),Toast.LENGTH_SHORT).show();
*/
    String msg="";
        switch (v.getId())
        {
            case R.id.button1:
                msg="button1";
                break;
            case R.id.button2:
                msg="button2";
                break;

        }
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();

    }
}
