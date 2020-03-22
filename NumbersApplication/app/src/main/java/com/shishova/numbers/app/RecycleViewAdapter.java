package com.shishova.numbers.app;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    ArrayList<Integer> numbersData = new ArrayList<>();
    Context context;

    View.OnClickListener myOnClickListener;

    public void setMyOnClickListener(View.OnClickListener myOnClickListener) {
        this.myOnClickListener = myOnClickListener;
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

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView numberView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Получение TextView, куда будет уставновлено число
            numberView = itemView.findViewById(R.id.item__title);
            // Добавление обработчика нажатия
            numberView.setOnClickListener(myOnClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return numbersData.size();
    }

    /**
     * Получение списка с числами
     * @return текущий список
     */
    public ArrayList<Integer> getNumbersData() {
        return numbersData;
    }

    /**
     * Добавление чисел в список + уведомление об изменении данных
     * @param newNumbers - список с числами
     */
    public void setNumbersData(ArrayList<Integer> newNumbers) {
        numbersData = newNumbers;

        notifyItemInserted(numbersData.size() - 1);
    }

    /**
     * Добавление констекста
     * @param cont - констекст
     */
    public void setContext(Context cont) {
        context = cont;
    }
}
