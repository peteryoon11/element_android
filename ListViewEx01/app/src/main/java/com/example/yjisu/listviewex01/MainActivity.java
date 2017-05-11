package com.example.yjisu.listviewex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 : ArrayList /  배열
        // 어댑터 <- 데이터
        // 리스트뷰 <- 어댑터
            // 리스트뷰는 스크롤 이 포함 되어 있다.
final ArrayList<String >  datas=new ArrayList<>();
        datas.add("수박 1 ");
        datas.add("딸기 2 ");
        datas.add("참외 3 ");
        datas.add("참외 4 ");
        datas.add("키위 5 ");
        datas.add("수박 6 ");
        datas.add("딸기 7 ");
        datas.add("참외 8 ");
        datas.add("참외 9 ");
        datas.add("키위 10 ");
        datas.add("수박 11 ");
        datas.add("딸기 12 ");
        datas.add("참외 13 ");
        datas.add("참외 14 ");
        datas.add("키위 15 ");
        datas.add("수박 16 ");
        datas.add("딸기 17 ");
        datas.add("참외 18 ");
        datas.add("참외 19 ");
        datas.add("키위 20 ");

       /* ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);

*/
       ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.country, android.R.layout.simple_list_item_1);


        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
            listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            listView.setOnItemClickListener
                    (new AdapterView.OnItemClickListener()
            {
                 /*   @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }*/
     @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         TextView textView=(TextView)view;
                     //       Toast.makeText(MainActivity.this,"선택 "+position,Toast.LENGTH_SHORT).show();
         Toast.makeText(MainActivity.this,"선택 "+textView.getText(),Toast.LENGTH_SHORT).show();
                    }
            });
    }
}
