package com.example.yjisu.seekbarex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=(TextView)findViewById(R.id.textView);

        SeekBar seekBar=(SeekBar)findViewById(R.id.seekBar);
seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        textView.append(progress+"\n");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        textView.append("onStartTrackingTouch \n");

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        textView.append("onStopTrackingTouch \n");

    }
});


    }
}
