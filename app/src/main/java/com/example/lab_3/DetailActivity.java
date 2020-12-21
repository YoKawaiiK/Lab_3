package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 *  Действие, представляющее один экран сведений об элементе
 *  Содержится в {@link MainActivity}.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // saveInstanceState не равен нулю, когда есть состояние фрагмента
        // сохранено из предыдущих конфигураций этого действия
        // (например, при повороте экрана из книжной в альбомную).
        // В этом случае фрагмент будет автоматически добавлен заново
        // в свой контейнер, поэтому нам не нужно добавлять его вручную.

        if (savedInstanceState == null) {
            // Создаем детали fragment и добавляем его
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));

            ItemDetailFragment fragment = new ItemDetailFragment();

            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.details, fragment)
                    .commit();
        }
    }

}