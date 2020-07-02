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
            isOn = !isOn;
        }else{
            handler.removeCallbacks(runnable);
            isOn = !isOn;
        }
    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            MiliTimeTotal++;
            handler.postDelayed(this, 0);

        }
    };


}
