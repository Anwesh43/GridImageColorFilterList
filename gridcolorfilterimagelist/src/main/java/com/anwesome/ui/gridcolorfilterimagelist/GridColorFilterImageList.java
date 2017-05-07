package com.anwesome.ui.gridcolorfilterimagelist;

import android.app.Activity;

/**
 * Created by anweshmishra on 07/05/17.
 */
public class GridColorFilterImageList {
    private Activity activity;
    private boolean isShown = false;
    public GridColorFilterImageList(Activity activity) {
        this.activity = activity;
    }
    public void addImage() {
        if(!isShown) {

        }
    }
    public void show() {
        if(!isShown) {
            isShown = true;
        }
    }
}
