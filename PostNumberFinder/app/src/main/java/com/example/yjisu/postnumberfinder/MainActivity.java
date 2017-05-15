package com.example.yjisu.postnumberfinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



/*

        ArrayList<MyItem> myItems= new ArrayList<>();

        MyItem myItem1= new MyItem(R.mipmap.ic_launcher,"노트북 1 ");
        MyItem myItem2= new MyItem(R.mipmap.ic_launcher,"노트북 2 ");
        MyItem myItem3= new MyItem(R.mipmap.ic_launcher,"노트북 3 ");
        MyItem myItem4= new MyItem(R.mipmap.ic_launcher,"노트북 4 ");
        MyItem myItem5= new MyItem(R.mipmap.ic_launcher,"노트북 5 ");

        myItems.add(myItem1);
        myItems.add(myItem2);
        myItems.add(myItem3);
        myItems.add(myItem4);
        myItems.add(myItem5);

        MyListAdapter myListAdapter= new MyListAdapter(this, myItems);
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(myListAdapter);
*/
/*
        ListView listView=(ListView)findViewById(R.id.listView);

*/

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("");
            */
                BufferedReader br = null;
                EditText editText = (EditText) findViewById(R.id.editText);
                if (editText.getText().length() < 2) {

                    Toast.makeText(MainActivity.this, "2글자 이상 입력", Toast.LENGTH_SHORT).show();
                }
else{
                try {
                    br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.zipcode)));
                    String data = "";
                    ArrayList<MyItem> myItems = new ArrayList<>();


                    MyItem myItem1 = null;
/*
                            new MyItem(R.mipmap.ic_launcher,"노트북 1 ");
                    myItems.add(myItem1);
*/

//                    int count =0;
                    ArrayList<String> arrayList = new ArrayList<String>();
                    while ((data = br.readLine()) != null) {
                        //                textView.append(data + "\n");
                        String temp[] = data.split(",");
                        String result = "";
                        for (int i = 1; i < temp.length; i++) {
                           System.out.println("temp["+i+"] : "+temp[i]);
                            result += temp[i] + " ";
                        }

/*
                        출처: http://all-record.tistory.com/118 [세상의 모든 기록]  temp.split(",");
                        */
                        // if(temp[3].contains(editText.getText().toString()))
                        if (result.contains(editText.getText().toString())) {
                //            if (temp[1].contains(editText.getText().toString())) {

                                myItem1 = new MyItem(R.mipmap.ic_launcher, result, temp[0].toString());
                            //temp[0] 은 포스트 넘버
                            myItems.add(myItem1);

                            //arrayList.add(data);
                        }
                        // arrayList.add(data.concat(editText.getText().toString()));


                    }
/*
                    while(count!=0)
                    {
                        myItem1= new MyItem(R.mipmap.ic_launcher,"노트북 1 ");
                        myItems.add(myItem1);
                        count--;
                    }*/

                    MyListAdapter myListAdapter = new MyListAdapter(MainActivity.this, myItems);
                    ListView listView = (ListView) findViewById(R.id.listView);
                    listView.setAdapter(myListAdapter);


                } catch (IOException e) {
                    e.printStackTrace();

                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            }
        });

    }
}
