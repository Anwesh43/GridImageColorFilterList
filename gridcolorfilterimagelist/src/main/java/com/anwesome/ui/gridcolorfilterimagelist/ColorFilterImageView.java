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
    private ColorFilter colorFilter;
    private Expander expander;
    private AnimationHandler animationHandler;
    public ColorFilterImageView(Context context,Bitmap bitmap,int color) {
        super(context);
        this.bitmap = bitmap;
        this.color = color;
        animationHandler = new AnimationHandler(this);
    }
    public void onDraw(Canvas canvas) {
        if(render == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            bitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);
            colorFilter = new ColorFilter();
            expander = new Expander();
        }
        canvas.drawBitmap(bitmap,0,0,paint);
        colorFilter.draw(canvas,paint);
        expander.draw(canvas,paint);

        render++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN && expander!=null) {
            expander.handleTap(event.getX(),event.getY());
        }
        return true;
    }
    public void update(float factor) {
        expander.update(factor);
        colorFilter.update(factor);
        postInvalidate();
    }
    private class Expander {
        private float x,y,size,deg = 0,dir = 1;
        public Expander() {
            x = w/2;
            y = h/2;
            size = w/10;
        }
        public void update(float factor) {
            deg = 180*factor;
        }
        public void draw(Canvas canvas,Paint paint) {
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(size/12);
            paint.setStrokeJoin(Paint.Join.ROUND);
            canvas.save();
            canvas.translate(x,y);
            for(int i=0;i<4;i++) {
                canvas.save();
                canvas.rotate(90*i);
                canvas.save();
                canvas.translate(0,-3*size/5);
                canvas.rotate(deg);
                canvas.drawLine(0,2*size/5,0,-2*size/5,paint);
                for(int j=0;j<2;j++) {
                    canvas.save();
                    canvas.translate(0,-2*size/5);
                    canvas.rotate(45*(2*j-1));
                    canvas.drawLine(0,0,0,size/3,paint);
                    canvas.restore();
                }
                canvas.restore();
                canvas.restore();
            }
            canvas.restore();
        }
        public void handleTap(float x,float y) {
            boolean condition =  x>=this.x - 3*size/2 && x<=this.x+3*size/2 && y>=this.y - 3*size/2 && y<=this.y+3*size/2;
            if(condition) {
                if(dir == 1) {
                    animationHandler.start();
                }
                else {
                    animationHandler.end();
                }
                dir*=-1;
            }
        }
    }
    private class ColorFilter {
        private float scale = 0;
        public void update(float factor) {
            scale = factor;
        }
        public void draw(Canvas canvas,Paint paint) {
            canvas.save();
            canvas.translate(w/2,h/2);
            canvas.scale(scale,scale);
            paint.setColor(Color.argb(150,Color.red(color),Color.green(color),Color.blue(color)));
            canvas.drawRect(new RectF(-w/2,-h/2,w/2,h/2),paint);
            canvas.restore();
        }
    }
}
