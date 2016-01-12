package com.shpp.vhudzal.cs;

import com.shpp.karel.KarelTheRobot;

/**
 * Created by ВЛАДИМИР on 28.11.2015.
 * Нахождение середины площадки
 */

public class Assignment1Part3 extends KarelTheRobot {
    @Override
    public void run() throws Exception {

            gotowall();
        }

    private void  moveForwardUntilWall() throws Exception {
        while (frontIsClear()){
            move();
        }
    }

    private void turnAround()throws Exception {
    turnLeft();
        turnLeft();
    }

    public void gotowall() throws Exception {

        putBeeper();
        moveForwardUntilWall();
        putBeeper();
        turnAround();
        if (frontIsClear()) {
            moveForwardUntilWall();
            if (beepersPresent()) {
                pickBeeper();
                turnAround();
                move();
            }
            putBeeper();
            moveForwardUntilWall();

            if (beepersPresent()) {
                pickBeeper();
                turnAround();
                move();
                putBeeper();
            }

            moveForwardUntilWall();
            if (beepersPresent()) {
                pickBeeper();
                turnAround();
                move();
                putBeeper();
            }
            move();
            if (beepersPresent()) {
                if (beepersPresent())
                    pickBeeper();
                turnAround();
                move();
                putBeeper();
            }
            move();
            if (beepersPresent()) {
                    pickBeeper();

                turnAround();
                move();
                putBeeper();}
                else
                pickBeeper();
                turnLeft();}}

        }
