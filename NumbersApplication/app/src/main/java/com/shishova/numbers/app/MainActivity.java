package com.shishova.numbers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentNumbersList.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Проверка: не пустной ли bundle, необходимо создавать фрагмент только  в начальном запуске Activity
        if (savedInstanceState == null) {
            // Получаем менеджер фрагментов и делаем транзакцию добавления фрагмента
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_activity__liner_layout, new FragmentNumbersList())
                    .commit();
        }
    }

    /**
     * Реализует транзакцию для отображения фрагмента с числом
     * @param args - bundle c числом, на которое нажали
     */
    public void getFragmentForNumber(Bundle args) {
        FragmentNumberView fragmentNumberView = new FragmentNumberView();
        fragmentNumberView.setArguments(args);
        // Замена существующего фрагмента с добавлением стека для удаления объекта по нажатию "Назад"
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity__liner_layout, fragmentNumberView)
                .addToBackStack(null)
                .commit();
    }
}
