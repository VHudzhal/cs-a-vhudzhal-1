package com.shpp.cs.vhudzal.graphicstest;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;


/**
 * Created by ВЛАДИМИР on 30.11.201
 */

public class Assignment2Part6 extends WindowProgram {
    public static final int DIAMETER = 100;
    private Window window = null;

    public void ViewWindow() {

    }
    @Override
    public void run(){
        setTitle("Caterpillar");
        final Window mainWindow;
        window = new Window(null);
        window.setSize(new Dimension(640, 480));
        window.setVisible(true);
        int x = (getWidth());
        int marginTop = (getHeight() - DIAMETER*3)/2;
        int marginLeft = (getWidth() - DIAMETER*6)/2;
/**
 * константы marginTop и marginLeft играют роль управления положения фигуры GOval
 */
        /**
         *первый овал - имеет начальное положение с нулевыми данными своего положения
         */

        drawTrack(x, marginTop, marginLeft, Color.GREEN, DIAMETER);
        /**
         *второй овал - имеет начальное положение с нулевыми данными своего положения
         */

        drawTrack(x, marginTop+DIAMETER/2, marginLeft/2, Color.GREEN, DIAMETER);
        /**
         *первый овал - имеет начальное положение с нулевыми данными своего положения
         */

        drawTrack(x, marginTop+DIAMETER, marginLeft, Color.GREEN, DIAMETER);
        /**
         *первый овал - имеет начальное положение с нулевыми данными своего положения
         */

        drawTrack(x, (int) (marginTop+DIAMETER*1.5), marginLeft/2, Color.GREEN, DIAMETER);
        /**
         *первый овал - имеет начальное положение с нулевыми данными своего положения
         */

        drawTrack(x, (int) (marginTop+DIAMETER*2), marginLeft, Color.GREEN, DIAMETER);
        /**
         *первый овал - имеет начальное положение с нулевыми данными своего положения
         */

        drawTrack(x, (int) (marginTop+DIAMETER*2.5), marginLeft/2, Color.GREEN, DIAMETER);
        /**
         *последний овал - имеет начальное положение с нулевыми данными своего положения
         */
        }

    private void drawTrack(int x, int marginTop, int marginLeft, Color color, int diameter) {
/**
 *Создание овала - класс имеет определенные заданные параметры фигуры:
 * цвет фигуры - setFillColor; цвет контура этой фигуры - setColor.
 */
        GOval o1 = getMeFilledOval(x, marginTop, marginLeft, diameter, diameter, color);
        o1.setFillColor(Color.GREEN);
        o1.setColor(Color.red);
        o1.setFilled(true);
        add(o1);
    }

    private void fillOval(GOval o1, Color c){
        o1.setFilled(true);
        o1.setFillColor(Color.GREEN);
        o1.setColor(Color.red);
        add(o1);
    }
    public GOval getMeFilledOval(int i, int x, int y, int width, int height, Color c) {

        GOval o1 = new GOval(x, y, width, height);
            o1.setFilled(true);
            o1.setFillColor(c);
            o1.setColor(c);
            add(o1);
        return o1;
    }
}