package com.example.yjisu.postnumfinder_sol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
private InputMethodManager inputMethodManager;

 //   private ArrayList<String> datas;

  private   ArrayList<HashMap<String, String>> datas ;

/*
    출처: http://musart.tistory.com/18 [bon appetit, musart~]*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    inputMethodManager=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        EditText editText=(EditText)findViewById(R.id.editText);
        String strDong =editText.getText().toString();
       // 입력 처리
        System.out.println("1111 log");
        if(strDong.length()<2)
        {
            Toast.makeText(MainActivity.this,"동 이름을 2자 이상 써주세요",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,strDong,Toast.LENGTH_SHORT).show();
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(),0);
            editText.setText("");

            datas= new ArrayList<>();



            BufferedReader br;


            br=new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.zipcode)));

            String address="";

            try {
                while ((address=br.readLine())!=null)
                {
                    System.out.println("2222 log");
                 //   System.out.print(address);
               String [] addresses= address.split(",");
             //       System.out.print(addresses[4]);
                    if(addresses.length>=3) {
                       // if (addresses[3].startsWith(strDong))
                        if (addresses[3].contains(strDong))
                        {
                        //    System.out.print(addresses[3]);

                            HashMap<String,String> data= new HashMap<String, String>();
                            data.put("v1",addresses[0]);
                            data.put("v2",address);

                            datas.add(data);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            if(br!=null)
            {
                try {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
            }

          //  ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,datas);
            SimpleAdapter adapter=new SimpleAdapter(MainActivity.this,
                    datas,android.R.layout.simple_list_item_2

            ,new String[]{"v1","v2"},new int[]{android.R.id.text1,android.R.id.text2});


            ListView listView=(ListView)findViewById(R.id.ListView);

            listView.setAdapter(adapter);


        }


    }
});

    }
}
