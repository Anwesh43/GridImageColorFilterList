package com.anwesome.ui.gridcolorfilterimagelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 07/05/17.
 */
public class GridImageLayout extends ViewGroup {
    private int w,h;
    public GridImageLayout(Context context) {
        super(context);
        initDimension(context);
    }
    public void initDimension(Context context) {
        DisplayManager displayManager = (DisplayManager)context.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        Point size = new Point();
        display.getRealSize(size);
        w = size.x;
        h = size.y;
    }
    public void onMeasure(int wspec,int hspec) {
        int newH = 0;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            measureChild(child,wspec,hspec);
            if(i%2 == 1) {
                newH+=child.getMeasuredHeight();
            }
        }
        setMeasuredDimension(w,Math.max(h,newH));
    }
    public void onLayout(boolean reloaded,int a,int b,int w,int h) {
        int x = 0,y = 0;
        for(int i=0;i<getChildCount();i++){
            View child = getChildAt(i);
            int viewW = child.getMeasuredWidth(),viewH = child.getMeasuredHeight();
            child.layout(x,y,x+viewW,y+viewH);
            if(i%2 == 1) {
                x = 0;
                y += viewH;
            }
            else {
                x+=viewW;
            }
        }
    }
    public void addImage(Bitmap bitmap,int color) {
        ColorFilterImageView colorFilterImageView = new ColorFilterImageView(getContext(),bitmap,color);
        addView(colorFilterImageView,new LayoutParams(w/2,h/4));
        requestLayout();
    }
}
