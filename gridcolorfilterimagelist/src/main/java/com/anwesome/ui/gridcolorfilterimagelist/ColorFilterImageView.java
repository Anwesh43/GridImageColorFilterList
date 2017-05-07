package com.anwesome.ui.gridcolorfilterimagelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 07/05/17.
 */
public class ColorFilterImageView extends View {
    private Bitmap bitmap;
    private int color;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int render = 0,w,h;
    public ColorFilterImageView(Context context,Bitmap bitmap,int color) {
        super(context);
        this.bitmap = bitmap;
        this.color = color;
    }
    public void onDraw(Canvas canvas) {
        if(render == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            bitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);
        }
        canvas.drawBitmap(bitmap,0,0,paint);
        render++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
    public void update(float factor) {

    }
}
