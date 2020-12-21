package com.example.lab_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Вспомогательный класс для заполнения списка */
public class DummyContent {

    /** Списочный массив элементов */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /** Списочный массив элементов */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();
    // Количество элементов
    private static final int COUNT = 25;

    static {
        // Добавление элементов в список.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }
    // Создание элемента
    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Элемент " + position, makeDetails(position));
    }

    // Создание информации об элементе для отдельной страницы
    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Информация об элементе: " + position);
        for (int i = 0; i < position; i++) {
            builder.append("\nДетальная информация.");
        }
        return builder.toString();
    }

    // Вставка созданного элемента в массив
    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /** Создание класса элементов для списка. */
    public static class DummyItem {
        public final String id; // id элемента
        public final String content; // содержание
        public final String details; // Детали

        // Конструктор элемента
        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
