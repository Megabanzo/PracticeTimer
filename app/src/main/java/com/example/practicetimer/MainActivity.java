package com.example.practicetimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rec;
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter mAdapter;
    public static int currentIndex;
    ArrayList timers;
    String s1[];
    Button newTimer;
    public static ArrayList<Timer> timerss;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rec = (RecyclerView)findViewById(R.id.myrecyclerview);
        newTimer = findViewById(R.id.newTimerButton);
        s1 = getResources().getStringArray(R.array.times);
        timers = new ArrayList<String>(Arrays.asList(s1));
        timerss = new ArrayList<Timer>();
        timers.add("foobar");
        for(int i = 10; i > 7; i--) {
            timerss.add(new Timer(i));

        }

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rec.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(this, timerss);
        mAdapter.setOnEntryClickListener(new MyAdapter.OnEntryClickListener() {
            @Override
            public void onEntryClick(View view, int position){
                currentIndex = position;
                Intent showTimer = new Intent(getApplicationContext(), MainTimer.class);
                startActivity(showTimer);
            }

        });
        rec.setAdapter(mAdapter);

    }
}