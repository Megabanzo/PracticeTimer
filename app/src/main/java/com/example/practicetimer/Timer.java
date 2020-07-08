package com.example.practicetimer;

import android.widget.Button;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;
import android.os.Handler;

import java.util.ArrayList;
import java.util.Arrays;

public class Timer {
    public long MiliTimeTotal, starTime;
    Handler handler;
    Boolean isOn;
    TextView tView;
    
    public Timer(int t){
        MiliTimeTotal = t;
        handler = new Handler();
        isOn = false;

    }
    public Timer(){
        MiliTimeTotal = 0;
        handler = new Handler();
        isOn = false;

    }
    public void startTimer(){
        starTime = SystemClock.uptimeMillis();

        if(!isOn) {
            handler.postDelayed(runnable, 0);
        }else{
            handler.removeCallbacks(runnable);
        }
        isOn = !isOn;
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            MiliTimeTotal++;
            MiliTimeTotal = SystemClock.uptimeMillis() -  starTime;
            tView.setText(Long.toString(MiliTimeTotal));
            handler.postDelayed(this, 0);
        }
    };


    public void setTextView(final TextView t){
        tView = t;
    }

}
