package com.shishova.numbers.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentNumbersList extends Fragment {

    public final String CLASS_NAME = "FragmentNumbersList";
    public final String NUMBERS_COUNT = "numbersCount";

    private static ArrayList<Integer> numbersData;

    private RecycleViewAdapter myDateAdapter;
    private RecyclerView recycle;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(CLASS_NAME, "onAttach");

        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(CLASS_NAME, "onCreate");

        int numbersCount = 5;

        if (savedInstanceState != null) {
            numbersCount = savedInstanceState.getInt(NUMBERS_COUNT);
        }

        numbersData = new ArrayList<>();
        for (int i = 1; i <= numbersCount; i++) {
            numbersData.add(i);
        }

        myDateAdapter = new RecycleViewAdapter(numbersData);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(CLASS_NAME, "onCreateView");

        View view = inflater.inflate(R.layout.fragment_numbers_list, container, false);
        recycle = view.findViewById(R.id.fragments_number_list__view);

        Button button = view.findViewById(R.id.fragments_number_list__button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numbersData.add(numbersData.size() + 1);
                myDateAdapter.setNumbersData(numbersData);
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        Log.d(CLASS_NAME, "onStart");
        super.onStart();

        int colCount = 3;

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            colCount = 4;
        }
        recycle.setLayoutManager(new GridLayoutManager(context, colCount));
        recycle.setAdapter(myDateAdapter);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(CLASS_NAME, "onSaveInstanceState");
        super.onSaveInstanceState(outState);

        outState.putInt(NUMBERS_COUNT, numbersData.size());
    }

    @Override
    public void onPause() {
        Log.d(CLASS_NAME, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(CLASS_NAME, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(CLASS_NAME, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onResume() {
        Log.d(CLASS_NAME, "onResume");
        super.onResume();
    }
}
