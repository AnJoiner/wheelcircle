package com.adaiyuns.wheelcircle.transformer;

import android.graphics.Rect;

import com.adaiyuns.wheelcircle.WheelView;

public interface WheelItemTransformer {
    /**
     * You have control over the Items draw bounds. By supplying your own WheelItemTransformer
     * you must call set bounds on the itemBounds.
     */
    void transform(WheelView.ItemState itemState, Rect itemBounds);
}