package com.adaiyuns.wheelcircle.transformer;

import android.graphics.drawable.Drawable;

import com.adaiyuns.wheelcircle.WheelView;

public interface WheelSelectionTransformer {
    void transform(Drawable drawable, WheelView.ItemState itemState);
}