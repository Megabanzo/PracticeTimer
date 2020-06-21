package com.example.practicetimer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data[];
    Context c;

    public MyAdapter(Context ct, String s[]){
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
        holder.myNumber.setText(position);
        holder.myTime.setText(data[position]);


    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myNumber, myTime;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myTime = itemView.findViewById(R.id.totalTime);
            myNumber = itemView.findViewById(R.id.tName);
        }
    }
}
