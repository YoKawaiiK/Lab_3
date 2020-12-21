package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View recyclerView = findViewById(R.id.list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }


    // Адаптер для RecyclerView
    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final MainActivity mParentActivity;
        private final List<DummyContent.DummyItem> mValues;


        // Конструктор
        SimpleItemRecyclerViewAdapter(MainActivity parent, List<DummyContent.DummyItem> items) {
            mValues = items;
            mParentActivity = parent;
        }

    }


}