package com.example.lab_3;

import android.app.Activity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * fragment отдельный экран сведений об элементе
 *  fragment содержится в {@link MainActivity}
 */
public class ItemDetailFragment extends Fragment {

    //Аргумент фрагмента, представляющий идентификатор элемента
    public static final String ARG_ITEM_ID = "item_id";

    //dummy содержание, которое представляет этот фрагмент
    private DummyContent.DummyItem mItem;

    // конструктор
    public ItemDetailFragment() {
    }

    // Создание текущей Activity
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Зарузка dummy контента
            // Поиск элемента в списке
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Показать содержимое элемента как текст в TextView
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail))
                    .setText(mItem.details);
        }

        return rootView;
    }
}
