package com.shpp.cs.vhudzal.graphicstest;

import acm.graphics.*;
import com.shpp.cs.a.graphics.WindowProgram;


import java.awt.*;

/**
 * Created by ВЛАДИМИР on 29.11.2015.
 */
public class TrikolorFlags extends WindowProgram {
    public static final Color YELLOW = Color.YELLOW;
    public static final Color RED = Color.RED;
    public static final Color BLACK = Color.BLACK;

    public void run() {
/**
 подключение всех трех частей флага: координаты, цвета*/
        GRect r1 = getFirstCols(70, 70, 200, 350, BLACK);
        add (r1);
        GRect r2 = getSecondCols(270, 70, 200,350, YELLOW);
        add(r2);
        GRect r3 = getThirdCols(470, 70, 200, 350, RED);
        add(r3);

/**
 создание надписи наименования страны, флаг которой изображается*/
        GLabel name = new GLabel("flags of Belgian");
        name.setColor( Color.BLACK);
        name.setFont("Verdana-15");
        add(name,getWidth()-name.getWidth(),(getHeight()*0.99));

     }
/**
 создание первого прямоугольника флага, создание характеристики фигуры
 * */
    private GRect getFirstCols(int x, int y, int width, int height, Color c) {
         GRect r1 = new GRect (x, y, width, height);
         r1.setColor(c);
         r1.setFilled( true );
         return r1;
    }
    /**
     создание второго прямоугольника флага, создание характеристики*/
    private GRect getSecondCols(int x, int y, int width, int height, Color c) {
        GRect r2 = new GRect (x, y, width, height);
        r2.setColor(c);
        r2.setFilled( true );
        return r2;
    }
    /**
     создание третьего прямоугольника флага, создание его характеристики
     */
    private GRect getThirdCols(int x, int y, int width, int height, Color c) {
        GRect r3;
        r3 = new GRect(x, y, width, height);
        r3.setColor(c);
r3.setFilled( true );
        return r3;
    }
}
