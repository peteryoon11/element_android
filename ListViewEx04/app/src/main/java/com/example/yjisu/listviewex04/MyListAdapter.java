package com.example.yjisu.listviewex04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by yjisu on 2017-05-11.
 */
// BaseAdapter : list view 에 데이터를 넣는 방법을 기술하는 것
public class MyListAdapter extends BaseAdapter {
    // 데이터 저장용

    public MyListAdapter( Context contex,ArrayList<MyItem> myItems) {
        this.myItems = myItems;
        this.contex = contex;
        // 수동으로 레이아웃을 객체화 하고 싶을때 사용하는 옵션
        this.layoutInflater=(LayoutInflater)contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    private ArrayList<MyItem> myItems;

    // 디자인 표현
    private LayoutInflater layoutInflater;
    private Context contex;


// 데이터의 갯수
    @Override
    public int getCount() {
        return myItems.size();
    }

    @Override
    public Object getItem(int position) {
        return myItems.get(position).getName();
        //
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        System.out.println("getview 호출 "+ position);
        // 1. 한 행의 디자인을 완성하는 방법
        final int pos = position;
        if(convertView==null)
        {
            convertView=layoutInflater.inflate(R.layout.item,parent, false);

        }
        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);

        imageView.setImageResource(myItems.get(pos).getIcon());


        TextView textView=(TextView)convertView.findViewById(R.id.textView);

        textView.setText(myItems.get(pos).getName());

        Button button= (Button)convertView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contex,pos+"클릭",Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }
}
