package com.example.yjisu.imageviewex01;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final TextView textView=null;

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView=(ImageView) findViewById(R.id.imageView2);
            //    imageView.setImageResource(R.drawable.image); //
                Bitmap bitmap=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.image),30,300,false);
                imageView.setImageBitmap(bitmap);
                 textView=(TextView)findViewById(R.id.textView);

                textView.append(imageView.getMeasuredWidth()+" ");

                textView.append(imageView.getMeasuredHeight()+"\n");

                textView.append(bitmap.getHeight()+" ");
                textView.append(bitmap.getHeight()+"\n");


            }
        });
    }
}
