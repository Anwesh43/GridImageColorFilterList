package com.anwesome.ui.gridcolorfilterimagelistdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.gridcolorfilterimagelist.GridColorFilterImageList;

public class MainActivity extends AppCompatActivity {
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(bitmap == null) {
            bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.back2);
        }
        String colorHexes[] = {"#009688","#00BCD4","#FF5722","#283593","#1976D2","#01579B","#e53935","#673AB7","#00838F","#1A237E","#d50000","#FFAB00"};
        GridColorFilterImageList gridColorFilterImageList = new GridColorFilterImageList(this);
        for(int i=0;i<colorHexes.length;i++) {
            gridColorFilterImageList.addImage(bitmap, Color.parseColor(colorHexes[i]));
        }
        gridColorFilterImageList.show();
    }
}
