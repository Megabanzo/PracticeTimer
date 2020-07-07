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
    public long MiliTimeTotal, starTime, buffer, upTime;
    Handler handler;
    Boolean isOn;
    TextView tView;
    int Seconds, Minutes, MilliSeconds,  Hours, Days;
    String stringTime;



    public Timer(int t){
        MiliTimeTotal = t;
        handler = new Handler();
        isOn = false;
        upTime = 0;

    }
    public Timer(){
        MiliTimeTotal = 0;
        handler = new Handler();
        isOn = false;
        upTime = 0;

    }
    public void startTimer(){
        starTime = SystemClock.uptimeMillis();

        if(!isOn) {
            handler.postDelayed(runnable, 0);
        }else{
            buffer += MiliTimeTotal;
            handler.removeCallbacks(runnable);
        }
        isOn = !isOn;
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            MiliTimeTotal = SystemClock.uptimeMillis() -  starTime;

            upTime = buffer + MiliTimeTotal;

            Seconds = (int) (upTime/1000);

            Minutes = Seconds / 60;

            Hours = Minutes / 60;

            Minutes = Minutes % 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (upTime %1000);

            stringTime = ("" + Days
                    + String.format("%02d", Hours) + ":"
                    + String.format("%02d", Minutes) + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            tView.setText(stringTime);
            handler.postDelayed(this, 0);
        }
    };


    public void setTextView(final TextView t){
        tView = t;
    }

}
