package com.example.yjisu.listviewex03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private InputMethodManager inputMethodManager;

    private ArrayList<String> datas;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    /*    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
datas= new ArrayList<>();
        datas.add("aaa");
        datas.add("bbb");
        datas.add("ccc");
        datas.add("ddd");

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);
        ListView listView=(ListView)findViewById(R.id.listView);

        listView.setAdapter(adapter);
      findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=(EditText)findViewById(R.id.edit_text);
                datas.add(editText.getText().toString());
                editText.setText("");
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(),0);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=(EditText)findViewById(R.id.edit_text);


                    datas.remove(editText.getText().toString());
                 //   datas.remove(editText.getText().toString());


                editText.setText("");
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(),0);
            }
        });
    }
}
