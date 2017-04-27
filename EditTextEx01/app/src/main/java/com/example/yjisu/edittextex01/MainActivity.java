package com.example.yjisu.edittextex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.id.button1;

public class MainActivity extends AppCompatActivity {

    InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);


        final EditText editText=(EditText)findViewById(R.id.edit_Text);

        Button button=(Button)findViewById(R.id.button1);
        final TextView textView=(TextView)findViewById(R.id.textView);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(),0);
        //    textView.setText(editText.getText());
       textView.append(editText.getText()+"\n");
            editText.setText("");

        }
    });
    }
}
