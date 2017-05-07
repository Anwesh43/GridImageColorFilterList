package com.anwesome.ui.gridcolorfilterimagelist;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 07/05/17.
 */
public class GridColorFilterImageList {
    private Activity activity;
    private GridImageLayout gridImageLayout;
    private ScrollView scrollView;
    private boolean isShown = false;
    public GridColorFilterImageList(Activity activity) {
        this.activity = activity;
        gridImageLayout = new GridImageLayout(activity);
        scrollView = new ScrollView(activity);
        scrollView.addView(gridImageLayout,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    public void addImage(Bitmap bitmap,int color) {
        if(!isShown) {
            gridImageLayout.addImage(bitmap,color);
        }
    }
    public void show() {
        if(!isShown) {
            activity.setContentView(scrollView);
            isShown = true;
        }
    }
}
