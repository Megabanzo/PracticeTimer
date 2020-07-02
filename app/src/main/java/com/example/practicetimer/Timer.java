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
    public long MiliTimeTotal;


    public Timer(int t){
        MiliTimeTotal = t;

    }
    public Timer(){
        MiliTimeTotal = 0;

    }


    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            MiliTimeTotal = SystemClock.uptimeMillis() - 1
        }
    };


}
