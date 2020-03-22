package com.shishova.numbers.app;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentNumberView extends Fragment {

    public final String CLASS_NAME = "FragmentNumberView";
    public static final String EXTRA_NUMBER = "Number";

    private int number;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(CLASS_NAME, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(CLASS_NAME, "onCreate");
        number = getArguments().getInt(EXTRA_NUMBER);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(CLASS_NAME, "onCreateView");

        View view = inflater.inflate(R.layout.fragment_number_view, container, false);
        TextView textNum = view.findViewById(R.id.fragment_number_view__title);

        int color = Color.BLUE;

        if (number % 2 == 0) {
            color = Color.RED;
        }

        textNum.setText(number + "");
        textNum.setTextColor(color);

        return view;
    }

    @Override
    public void onStart() {
        Log.d(CLASS_NAME, "onStart");
        super.onStart();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(CLASS_NAME, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
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
