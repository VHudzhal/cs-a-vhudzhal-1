package com.shpp.vhudzal.cs;

import com.shpp.karel.KarelTheRobot;

/**
 * 
 */
public class Assignment1Part4 extends KarelTheRobot {
    public void run() throws Exception {
        collectAllCheckers();
        turnAround();
        arrangeCheckers();

            }
    /**сбор всех биперов*/

    public void collectAllCheckers() throws Exception{
        for (int i = 0; i < 3; i++){
            sweepTwoRows();
            twistfromWest();
            if(beepersPresent()){
                pickBeeper();}}
        sweepTwoRows();
    }
/**расставляем биперы в шахматном порядке*/
    private void arrangeCheckers() throws Exception{
        {
            for(int i = 0; i < 4; i++){
            move();
            arrangeRowToEast();
                twistfromWest();
            move();
            arrangeRowToWest();
                if(leftIsBlocked()){
                    turnAround();
                    if(beepersPresent()){
                        move();
                    }
                }
                else{
                twistfromEast();
            }
            }

            }
            }
/**заполнить в восточномом направлении*/
    private void arrangeRowToEast() throws Exception{
        {
            for(int i = 0; i < 5; i++){
                putBeeper();
                move();
                move();}
            putBeeper();
        }

if(frontIsBlocked())
{

}
    }

/**заполнитьв западном направлении*/
    private void arrangeRowToWest() throws Exception{
        {
            for(int i = 0; i < 5; i++){
                putBeeper();
                move();
                move();}
            putBeeper();

            }
        }





public void sweepTwoRows() throws Exception{
    WalkAndPickBeepers();
    if(frontIsBlocked()){
        twistfromEast();
        WalkAndPickBeepers();

}}

/**поворот запад --> восток*/
    public void twistfromWest() throws Exception{

        turnRight();
        move();
        turnRight();
        if(beepersPresent()){
            WalkAndPickBeepers();}


    }
    /**поворот запад <-- восток*/
    public void twistfromEast() throws Exception

    {
        turnLeft();
        move();
        turnLeft();}



    private void WalkAndPickBeepers() throws Exception {
             while (frontIsClear()) {
                if (beepersPresent()) {
                    pickBeeper();
                }
                 if(noBeepersPresent()){
                move();}
            }
            if (beepersPresent()) {
                pickBeeper();
            }
        }

    private void turnRight() throws Exception{
        turnLeft();
        turnLeft();
        turnLeft();}
    private void turnAround() throws Exception{
        turnLeft();
        turnLeft();
    }
    private void  moveForwardUntilWall() throws Exception {
        while (frontIsClear()){
            move();
        }}
    }


