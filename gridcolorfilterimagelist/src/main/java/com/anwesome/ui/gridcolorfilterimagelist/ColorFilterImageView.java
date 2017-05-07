package com.anwesome.ui.gridcolorfilterimagelist;

import android.content.Context;
import android.graphics.*;
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
    private class Expander {
        private float x,y,size,deg = 0;
        public Expander() {
            x = w/2;
            y = h/2;
            size = w/20;
        }
        public void update(float factor) {
            deg = 180*factor;
        }
        public void draw(Canvas canvas,Paint paint) {
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(size/20);
            canvas.save();
            canvas.translate(x,y);
            for(int i=0;i<4;i++) {
                canvas.save();
                canvas.rotate(90*i);
                canvas.save();
                canvas.translate(0,-3*size/5);
                canvas.rotate(deg);
                canvas.drawLine(0,-size/5,0,-size,paint);
                for(int j=0;j<2;j++) {
                    canvas.save();
                    canvas.translate(0,-size);
                    canvas.rotate(45*(2*i-1));
                    canvas.drawLine(0,0,0,size/3,paint);
                    canvas.restore();
                }
                canvas.restore();
                canvas.restore();
            }
            canvas.restore();
        }
    }
}
