package com.shishova.numbers.app;

import androidx.appcompat.app.AppCompatActivity;
import com.shishova.numbers.app.FragmentNumbersList;
import com.shishova.numbers.app.FragmentNumberView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentNumbersList.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_activity__liner_layout, new FragmentNumbersList())
                    .commit();
        }
    }

    public void getFragmentForNumber(Bundle args) {
        FragmentNumberView fragmentNumberView = new FragmentNumberView();
        fragmentNumberView.setArguments(args);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity__liner_layout, fragmentNumberView)
                .addToBackStack(null)
                .commit();
    }
}
