package com.example.yjisu.fragmentex01;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getFragmentManager();

        final Fragment fragment=fragmentManager.findFragmentById(R.id.fragment);



        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView1=(TextView)findViewById(R.id.textView1);
                TextView textView2=(TextView)fragment.getActivity().findViewById(R.id.textView2);

                if(textView1.getText().length()>2)
                {
                    textView1.setText("");

                    textView2.setText("");
                }
                else
                {
                    textView1.setText("메인에서 버튼에서 변경됨 ");

                    textView2.setText("메인에서 버튼에서 변경됨 ");
                }
            }
        });
    }


    // 부분 디자인을 처리하는 방법!

    public static class CustomFragment extends Fragment
    {

        // activity 의 Oncreate
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

            // inflater - xml 문서 내부 디자인을 객체화 시키는 역할
          final   View view=inflater.inflate(R.layout.fragment, container,false);
            Button button=(Button)view.findViewById(R.id.button2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView1=(TextView)getActivity().findViewById(R.id.textView1);
                    TextView textView2=(TextView)view.findViewById(R.id.textView2);

                    if(textView1.getText().length()>2)
                    {
                        textView1.setText("");

                        textView2.setText("");
                    }
                    else
                    {
                        textView1.setText("플래그먼트 버튼에서 변경됨 ");

                        textView2.setText("플래그먼트 버튼에서 변경됨 ");
                    }


                }
            });

            return  view;
            //return super.onCreateView(inflater, container, savedInstanceState);
        }
    }
}
