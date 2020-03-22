package com.shishova.numbers.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    ArrayList<Integer> numbersData = new ArrayList<>();

    public RecycleViewAdapter(ArrayList<Integer> data) { numbersData = data;}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int currentNumber = numbersData.get(position);
        holder.numberView.setText(String.valueOf(currentNumber));
    }

    @Override
    public int getItemCount() {
        return numbersData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView numberView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            numberView = itemView.findViewById(R.id.item__title);
        }
    }
}
