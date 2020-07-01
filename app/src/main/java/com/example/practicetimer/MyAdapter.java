package com.example.practicetimer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myNumber.setText(Integer.toString(position + 1));
        holder.myTime.setText(Long.toString(data.get(position).MiliTimeTotal));


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView myNumber, myTime;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            myTime = itemView.findViewById(R.id.totalTime);
            myNumber = itemView.findViewById(R.id.tName);

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
