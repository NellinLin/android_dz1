package com.shishova.numbers.app;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    ArrayList<Integer> numbersData = new ArrayList<>();
    Context context;

    private OnEntryClickListener onEntryClickListener;
    public interface OnEntryClickListener {
        void onEntryClick(View view, int position);
    }

    public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener) {
        Log.d("onClick", "SetEntry");
        this.onEntryClickListener = onEntryClickListener;
    }


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
        int color = Color.BLUE;

        if (currentNumber % 2 == 0) {
            color = Color.RED;
        }
        holder.numberView.setText(String.valueOf(currentNumber));
        holder.numberView.setTextColor(color);
    }

    @Override
    public int getItemCount() {
        return numbersData.size();
    }

    public ArrayList<Integer> getNumbersData() {
        return numbersData;
    }

    public void setNumbersData(ArrayList<Integer> newNumbers) {
        numbersData = newNumbers;

        notifyItemInserted(numbersData.size() - 1);
    }

    public void setContext(Context cont) {
        context = cont;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView numberView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d("onClick", "Click");
            numberView = itemView.findViewById(R.id.item__title);
            numberView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("onClick", "Click");
            onEntryClickListener.onEntryClick(v, getLayoutPosition());
        }
    }
}
