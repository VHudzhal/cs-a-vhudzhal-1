package com.shpp.cs.vhudzal.graphicstest;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * Created by ВЛАДИМИР on 29.11.2015.*/
 public class Assignment2Part3 extends WindowProgram {
    /* Constants controlling the relative positions of the
     * three toes to the upper-left corner of the pawprint.
     *
     * (Yes, I know that actual pawprints have four toes.
     * Just pretend it's a cartoon animal. ^_^)
     */
    private static final double FIRST_TOE_OFFSET_X = 20;
    private static final double FIRST_TOE_OFFSET_Y = 35;
    private static final double SECOND_TOE_OFFSET_X = 50;
    private static final double SECOND_TOE_OFFSET_Y = 15;
    private static final double THIRD_TOE_OFFSET_X = 80;
    private static final double THIRD_TOE_OFFSET_Y = 35;

    /* The position of the heel relative to the upper-left
     * corner of the pawprint.
     */
    private static final double HEEL_OFFSET_X = 40;
    private static final double HEEL_OFFSET_Y = 55;

    /* Each toe is an oval with this width and height. */
    private static final double TOE_WIDTH = 20;
    private static final double TOE_HEIGHT = 30;

    /* The heel is an oval with this width and height. */
    private static final double HEEL_WIDTH = 40;
    private static final double HEEL_HEIGHT = 60;

    /* The default width and height of the window. These constants will tell Java to
     * create a window whose size is *approximately* given by these dimensions. You should
     * not directly use these constants in your program; instead, use getWidth() and
     * getHeight(), which return the *exact* width and height of the window.
     */
    public static final int APPLICATION_WIDTH = 270;
    public static final int APPLICATION_HEIGHT = 220;

    public void run() {
        drawPawprint(20, 20);
        drawPawprint(180, 70);
    }

    /**
     * Draws a pawprint. The parameters should specify the upper-left corner of the
     * bounding box containing that pawprint.
     *  @param x The x coordinate of the upper-left corner of the bounding box for the pawprint.
     * @param y The y coordinate of the upper-left corner of the bounding box for the pawprint.
     */
    private void drawPawprint(double x, double y) {
        getWidth();
        getHeight();
        x = (getWidth() + APPLICATION_WIDTH)/3.5;
        y = (getHeight() + APPLICATION_HEIGHT)/3.5;


        /**
         *
         */
            GOval HELL = new GOval(HEEL_OFFSET_X, HEEL_OFFSET_Y, HEEL_WIDTH, HEEL_HEIGHT);
        HELL.setFillColor(Color.BLACK);
        HELL.setFilled(true);
        HELL.setColor(Color.BLACK);
        add(HELL);

            HELL = new GOval(x, y-10, HEEL_WIDTH, HEEL_HEIGHT);
            HELL.setFillColor(Color.BLACK);
            HELL.setFilled(true);
        HELL.setColor(Color.BLACK);
            add(HELL);

        GOval FIRST_TOE = new GOval(FIRST_TOE_OFFSET_X, FIRST_TOE_OFFSET_Y, TOE_WIDTH, TOE_HEIGHT);
        FIRST_TOE.setFillColor(Color.BLACK);
        FIRST_TOE.setFilled(true);
        FIRST_TOE.setColor(Color.BLACK);
        add(FIRST_TOE);

            FIRST_TOE = new GOval(x-20,y-30, TOE_WIDTH, TOE_HEIGHT);
            FIRST_TOE.setFillColor(Color.BLACK);
            FIRST_TOE.setFilled(true);
        FIRST_TOE.setColor(Color.BLACK);
            add(FIRST_TOE);

        GOval SECOND_TOE = new GOval(SECOND_TOE_OFFSET_X, SECOND_TOE_OFFSET_Y, TOE_WIDTH, TOE_HEIGHT);
        SECOND_TOE.setFillColor(Color.BLACK);
        SECOND_TOE.setFilled(true);
        SECOND_TOE.setColor(Color.BLACK);
        add(SECOND_TOE);

            SECOND_TOE = new GOval(x+10, y-50, TOE_WIDTH, TOE_HEIGHT);
            SECOND_TOE.setFillColor(Color.BLACK);
            SECOND_TOE.setFilled(true);
        SECOND_TOE.setColor(Color.BLACK);
            add(SECOND_TOE);

        GOval THIRD_TOE = new GOval(THIRD_TOE_OFFSET_X, THIRD_TOE_OFFSET_Y, TOE_WIDTH, TOE_HEIGHT);
        THIRD_TOE.setFillColor(Color.BLACK);
        THIRD_TOE.setFilled(true);
        THIRD_TOE.setColor(Color.BLACK);
        add(THIRD_TOE);

            THIRD_TOE = new GOval(x+40, y-30, TOE_WIDTH, TOE_HEIGHT);
            THIRD_TOE.setFillColor(Color.BLACK);
            THIRD_TOE.setFilled(true);
        THIRD_TOE.setColor(Color.BLACK);
            add(THIRD_TOE);
    }
}
