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
    ArrayList timers;
    String s1[];
    Button newTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rec = (RecyclerView)findViewById(R.id.myrecyclerview);


        s1 = getResources().getStringArray(R.array.times);
        timers = new ArrayList<String>(Arrays.asList(s1));
        timers.add("foobar");

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rec.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(this, timers);
        mAdapter.setOnEntryClickListener(new MyAdapter.OnEntryClickListener() {
            @Override
            public void onEntryClick(View view, int position){
                Intent showTimer = new Intent(getApplicationContext(), MainTimer.class);
                startActivity(showTimer);
            }

        });
        rec.setAdapter(mAdapter);

    }
}