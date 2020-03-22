package com.shishova.numbers.app;

import androidx.appcompat.app.AppCompatActivity;
import com.shishova.numbers.app.FragmentNumbersList;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
}
