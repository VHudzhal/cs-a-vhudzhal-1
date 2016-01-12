package com.shpp.vhudzal.cs;

import com.shpp.karel.KarelTheRobot;

/**
 * Created by ВЛАДИМИР on 28.11.2015.
 | xxx xxx xxx |
 |xx xxx xxx xx|
 |x   x   x   x|
 |1       1   1|
 |1   1        |
 |        1   1|
 |    1        |
 |>   1       1|
 */

public class Assignment1Part2 extends KarelTheRobot {
    @Override
    public void run() throws Exception {
        turnLeft();
        sweepRow();
        FillColumnBeepers();
             for (int i = 0; i < 2; i++)
        {
        repairColumn();
        }
        goToNext();
        FillColumnBeepers();
        }

    private void repairColumn() throws  Exception {
        goToNext();
        FillColumnBeepers();
        returnBack();
    }

    private void returnBack() throws  Exception {
    turnAround();
        moveForwardUntilWall();
        if (noBeepersPresent()) {
            putBeeper();
        }
    }


    private void sweepRow() throws Exception {
        WalkAndPickBeepers();
        turnAround();
    }


    private void WalkAndPickBeepers() throws Exception{
      while (frontIsClear()){
        if(beepersPresent()){
            pickBeeper();
        }
    move();

    }}

    private void goToNext() throws  Exception{
        turnLeft();
        move();
        move();
        move();
        move();
        turnLeft();
            if (noBeepersPresent()) {
                putBeeper();
            }
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }


    private void FillColumnBeepers() throws Exception {
        while(frontIsClear())
        {
            move();
        if (noBeepersPresent()) {
                putBeeper();
            }
        }}
    private void  moveForwardUntilWall() throws Exception {
        while (frontIsClear()){
            move();
        }}
}
