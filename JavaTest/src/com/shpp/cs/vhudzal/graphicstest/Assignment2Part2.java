package com.shpp.cs.vhudzal.graphicstest;

import acm.graphics.*;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;


public class Assignment2Part2 extends WindowProgram{
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 500;
    public static  final  int DIAMETER = 100;
@Override
   public void run() {

geometricalFigures();
   }

public void geometricalFigures()
{
    getWidth();
    getHeight();
    double x = ((getWidth() - APPLICATION_WIDTH)/2);
    double y = ((getHeight() - APPLICATION_HEIGHT)/2);

    /**
     создание 4-х овалов типа  GOval c параметрами: координаты, размер, цвет закрашывания;
     */

    GOval o1 = new GOval(100,70, DIAMETER, DIAMETER);
    o1.setFillColor( Color.BLACK);
    o1.setFilled( true );
    add(o1);

    GOval o2 = new GOval( 300, 70, DIAMETER, DIAMETER);
    o2.setFillColor(Color.BLACK);
    o2.setFilled( true );
    add(o2);

    GOval o3 = new GOval( 100, 270, DIAMETER, DIAMETER);
    o3.setFillColor( Color.BLACK );
    o3.setFilled( true );
    add(o3);

    GOval o4 = new GOval( 300, 270, 100, 100 );
    o4.setFillColor( Color.BLACK);
    o4.setFilled( true );
    add(o4);
/**
 Создания прямоугольника, находящегося за 4-а овалами, имеющего такие же параметры:
 координаты, размер фигуры, ее цвет закрашивания;
 */
    GRect r1 = new GRect(150,120, 200, 200);
    r1.setFillColor( Color.BLACK );
    r1.setFilled( true );
    add (r1);

}


}

