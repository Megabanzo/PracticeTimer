package com.example.practicetimer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Handler;

import java.util.List;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;



public class MainTimer extends AppCompatActivity {

    TextView textView ;

    Button start, pause, reset, lap ;

    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;

    Handler handler;

    int Seconds, Minutes, MilliSeconds ;

    ListView listView ;
    Timer timer;

    String timerStringTime;

    String[] ListElements = new String[] {  };

    List<String> ListElementsArrayList ;

    public ArrayAdapter<String> adapter ;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintimer);
        timer = MainActivity.timerss.get(MainActivity.currentIndex);
        textView = (TextView)findViewById(R.id.textView);
        start = (Button)findViewById(R.id.startButton);
        reset = (Button)findViewById(R.id.resetButton);
        lap = (Button)findViewById(R.id.lapButton);
        pause = (Button)findViewById(R.id.pauseButton) ;
        listView = (ListView)findViewById(R.id.listview1);
        timerStringTime = timer.stringTime;
        MillisecondTime = timer.MiliTimeTotal;
        textView.setText(timerStringTime);
        handler = new Handler() ;

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));
        if(timer.isOn){
            handler.postDelayed(updateTimierview, 0);
        }
        adapter = new ArrayAdapter<String>(MainTimer.this,
                android.R.layout.simple_list_item_1,
                ListElementsArrayList
        );

        listView.setAdapter(adapter);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!timer.isOn) {

                    handler.postDelayed(updateTimierview, 0);
                }else{
                    handler.removeCallbacks(updateTimierview);
                }
                timer.startTimer();

                reset.setEnabled(false);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(updateTimierview);

                reset.setEnabled(true);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MillisecondTime = 0L ;
                StartTime = 0L ;
                TimeBuff = 0L ;
                UpdateTime = 0L ;
                Seconds = 0 ;
                Minutes = 0 ;
                MilliSeconds = 0 ;

                textView.setText("00:00:00");

                ListElementsArrayList.clear();

                adapter.notifyDataSetChanged();
            }
        });

        lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListElementsArrayList.add(textView.getText().toString());

                adapter.notifyDataSetChanged();

            }
        });

    }

    public Runnable updateTimierview = new Runnable() {

        public void run() {

//            MillisecondTime = SystemClock.uptimeMillis() - StartTime;
//
//            UpdateTime = TimeBuff + MillisecondTime;
//
//            Seconds = (int) (UpdateTime / 1000);
//
//            Minutes = Seconds / 60;
//
//            Seconds = Seconds % 60;
//
//            MilliSeconds = (int) (UpdateTime % 1000);

//            textView.setText("" + Minutes + ":"
//                    + String.format("%02d", Seconds) + ":"
//                    + String.format("%03d", MilliSeconds));

            textView.setText(timer.stringTime);
            handler.postDelayed(this, 0);
        }

    };

}




