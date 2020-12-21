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


        // возвращает объект ViewHolder
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_content, parent, false);
            return new ViewHolder(view);
        }

        // выполняет привязку объекта ViewHolder к объекту Phone по определенной позиции
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).content);
            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        // возвращает количество объектов в списке
        @Override
        public int getItemCount() {
            return mValues.size();
        }


        // хранит данные по одному объекту
        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }


}