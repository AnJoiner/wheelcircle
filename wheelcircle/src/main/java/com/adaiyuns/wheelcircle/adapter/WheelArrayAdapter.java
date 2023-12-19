package com.adaiyuns.wheelcircle.adapter;

import java.util.List;

public abstract class WheelArrayAdapter<T> implements WheelAdapter {
    private List<T> data;

    public WheelArrayAdapter(List<T> items) {
        data = items;
    }

    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}