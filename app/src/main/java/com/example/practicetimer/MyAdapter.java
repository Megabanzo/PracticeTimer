package com.example.practicetimer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Timer> data;
    public Context c;
    private OnEntryClickListener mOnEntryClickListener;

    public MyAdapter(Context ct, ArrayList<Timer> s){
        data = s;
        c = ct;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(c);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.myNumber.setText(Integer.toString(position + 1));
        holder.myTime.setText(Long.toString(data.get(position).MiliTimeTotal));
        MainActivity.timerss.get(position).setTextView(holder.myTime);
        holder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.lastClicked = position;

                MainActivity.timerss.get(position).startTimer(holder.myTime);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView myNumber, myTime;
        public Button cloneButton, playButton;
        Handler handler;
        int lastClicked;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            myTime = itemView.findViewById(R.id.totalTime);
            myNumber = itemView.findViewById(R.id.tName);
            playButton = itemView.findViewById(R.id.PlayButton);
            cloneButton = itemView.findViewById(R.id.CloneButton);
            handler = new Handler() ;


        }
        @Override
        public void onClick(View v){
            if (mOnEntryClickListener != null){
                mOnEntryClickListener.onEntryClick(v, getLayoutPosition());
            }
        }

    }

    public interface OnEntryClickListener {
        void onEntryClick(View view, int position);
    }

    public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener){
        mOnEntryClickListener = onEntryClickListener;
    }

}
