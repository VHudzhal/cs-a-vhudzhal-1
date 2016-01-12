package com.shpp.vhudzal.cs;

import com.shpp.karel.KarelTheRobot;
/**
 * Created by ВЛАДИМИР
 * Задание подобрать газетку(CollectNewspaper)
 */


public class Assignment1Part1 extends KarelTheRobot{
    public void run() throws Exception {
        picknewspaper();
        reverseorder();

    }

    /**
     забрать газету
     */
    private void picknewspaper() throws Exception{
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        move();
        pickBeeper();
    }
    /**
    Условие (двигаться, пока не вопрошся в стену)
     */
    private void  moveForwardUntilWall() throws Exception {
        while (frontIsClear()){
            move();
        }}

    /**
     * Принести газету домой
     */
   private void reverseorder() throws Exception{
    turnLeft();
    turnLeft();
       moveForwardUntilWall();
       turnRight();
       move();
       putBeeper();
}

    public void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }


    }
