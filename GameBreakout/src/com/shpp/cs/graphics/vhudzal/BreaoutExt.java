package com.shpp.cs.graphics.vhudzal;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Created by ВЛАДИМИР on 13.12.2015.
 */
public class BreaoutExt extends WindowProgram{
    // Width and height of application window in pixels.
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    // Dimensions of game board (usually the same).
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    // Dimensions of the paddle.
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    // Offset of the paddle up from the bottom.
    private static final int PADDLE_Y_OFFSET = 30;

    // Number of bricks per row.
    private static final int NBRICKS_PER_ROW = 10;

    // Number of rows of bricks.
    private static final int NBRICK_ROWS = 10;

    // Separation between bricks.
    private static final int BRICK_SEP = 4;

    // Width of a brick.
    private static final int BRICK_WIDTH = (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    // Height of a brick.
    private static final int BRICK_HEIGHT = 8;

    // Radius of the ball in pixels.
    private static final int BALL_RADIUS = 10;

    // Offset of the top brick row from the top.
    private static final int BRICK_Y_OFFSET = 70;

    // Offset of the first brick column from the left.
    private static final int BRICK_X_OFFSET = (WIDTH - (NBRICKS_PER_ROW * BRICK_WIDTH) -
            (NBRICKS_PER_ROW - 1) * BRICK_SEP) / 2;

    // Colors of all objects on the game board.
    private static final Color WALLS_COLOR = Color.BLACK;
    private static final Color BALL_COLOR = new Color(220, 220, 220);
    private static final Color PADDLE_COLOR = new Color(150, 150, 150);
    private static final Color BRICKS_ROWS_COLORS[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
    private static final Color BACKGROUND_COLOR = new Color(139, 69, 19);
    // Number of turns.
    private static final int NTURNS = 3;

    private GRect paddle = null;
    private GOval ball = null;
    private double vX = 0, vY = 0;

    public void run() {
        addWalls();
        int totalBricksCount = addBricks();
        addPaddle();
        addMouseListeners();
        addKeyListener();
        addBall();
        playGame(totalBricksCount);

    }

    private void addKeyListener() {

    }

    /**
     * Add walls on the game board.
     */
    private void addWalls() {
        GRect leftWall = new GRect(-10, 0, 10, getHeight());
        leftWall.setColor(WALLS_COLOR);
        leftWall.setFillColor(WALLS_COLOR);
        leftWall.setFilled(true);
        add(leftWall);
        GRect rightWall = new GRect(getWidth(), 0, 10, getHeight());
        rightWall.setColor(WALLS_COLOR);
        rightWall.setFillColor(WALLS_COLOR);
        rightWall.setFilled(true);
        add(rightWall);
        GRect topWall = new GRect(0, -10, getWidth(), 10);
        topWall.setColor(WALLS_COLOR);
        topWall.setFillColor(WALLS_COLOR);
        topWall.setFilled(true);
        add(topWall);
        GRect bottomWall = new GRect(0, getHeight() + BALL_RADIUS * 2, getWidth(), 10);
        bottomWall.setColor(WALLS_COLOR);
        bottomWall.setFillColor(WALLS_COLOR);
        bottomWall.setFilled(true);
        add(bottomWall);
        setBackground(BACKGROUND_COLOR);
    }

    /**
     * Add paddle on the game board.
     */
    private void addPaddle() {
        paddle = new GRect((getWidth() - PADDLE_WIDTH) / 2, getHeight() - PADDLE_Y_OFFSET,
                PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setColor(PADDLE_COLOR);
        paddle.setFillColor(PADDLE_COLOR);
        paddle.setFilled(true);
        add(paddle);
    }

    /**
     * Add ball on the game board.
     */
    private void addBall() {
        ball = new GOval(getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS,
                BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setColor(BALL_COLOR);
        ball.setFillColor(BALL_COLOR);
        ball.setFilled(true);
        add(ball);
    }

    /**
     * Add bricks on the game board.
     */
    private int addBricks() {
        for (int i = 0; i < NBRICK_ROWS; i ++)
            for (int j = 0; j < NBRICKS_PER_ROW; j ++) {
                GRect brick = new GRect(BRICK_X_OFFSET + j * (BRICK_WIDTH + BRICK_SEP),
                        BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT);
                brick.setColor(BRICKS_ROWS_COLORS[i % 10 / 2]);
                brick.setFillColor(BRICKS_ROWS_COLORS[i % 10 / 2]);
                brick.setFilled(true);
                add(brick);
            }
        return NBRICK_ROWS * NBRICKS_PER_ROW;
    }

    /**
     * Link center of the paddle with mouse cursor and move it only in horizontal direction.
     *
     * @param mouseEvent - Mouse event.
     */
    public void mouseMoved(MouseEvent mouseEvent) {
        double cursorX = mouseEvent.getX();
        double cursorXMin = PADDLE_WIDTH / 2;
        double cursorXMax = getWidth() - PADDLE_WIDTH / 2;
        if (cursorX < cursorXMin)
            cursorX = cursorXMin;
        if (cursorX > cursorXMax)
            cursorX = cursorXMax;
        paddle.setLocation(cursorX - PADDLE_WIDTH / 2, getHeight() - PADDLE_Y_OFFSET);

    }

    public void keyPressed(KeyEvent keyEvent){
      { int key = keyEvent.getKeyCode();
          if (key == KeyEvent.VK_LEFT)
          {

          }
          if (key == KeyEvent.VK_RIGHT)
          {

          }
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        }
    /**
     * Play the game. Game is over if player used all three turns (lose) or break all bricks (win).
     *
     * @param totalBricksCount - Total bricks count for break to win.
     */
    private void playGame(int totalBricksCount) {
        for (int i = 1; i <= NTURNS; i ++) {
            totalBricksCount = playTurn(totalBricksCount);
            if (totalBricksCount == 0)
                break;
        }
        gameOver(totalBricksCount);
    }

    /**
     * Output message with game result - win or lose.
     *
     * @param totalBricksCount - Total bricks count for break to win.
     *                         If param value equals 0, game is win, else game is lose.
     */
    private void gameOver(int totalBricksCount) {
        GLabel result = null;
        if (totalBricksCount == 0) {
            result = new GLabel("YOU WIN! CONGRATULATIONS!");
            playSound("success.wav");
        } else {
            result = new GLabel("YOU LOSE! TRY ONES MORE!");
            playSound("gameover.wav");
        }
        result.setFont(new Font("Courier New", Font.BOLD, 24));
        result.setColor(Color.RED);
        result.setLocation((getWidth() - result.getWidth()) / 2, getHeight() / 2);
        add(result);
    }

    /**
     * Add sounds in the game for more interesting game play.
     *
     * @param fileName - Name of the sounded file.
     */
    private void playSound(String fileName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    /**
     * Play one turn of the three. The ball is located in the center of the game board and wait for click.
     * After this turn is started.
     *
     * @param totalBricksCount - Total bricks count to win before play current turn.
     * @return - Total bricks count to win after play current turn.
     */
    private int playTurn(int totalBricksCount) {
        setStartBallPositionAndSpeed();
        //language=file-reference
        playSound("getready.wav");
        waitForClick();
        totalBricksCount = moveBall(totalBricksCount);
        return totalBricksCount;
    }

    /**
     * Locate the ball in the center of the game board and randomly set its move direction and speed.
     */
    private void setStartBallPositionAndSpeed() {
        ball.setLocation(getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS);
        vY = 3.0;
        RandomGenerator randomGenerator = RandomGenerator.getInstance();
        vX = randomGenerator.nextDouble(1.0, 3.0);
        if (randomGenerator.nextBoolean(0.5))
            vX = -vX;
    }

    /**
     * Move the ball until one of two events: ball leave the game board (turn is lose)
     * or last brick was break (turn and game is win).
     *
     * @param totalBricksCount - Total bricks count before starting move ball.
     * @return  - Total bricks count after finishing move ball.
     */
    private int moveBall(int totalBricksCount) {
        while (true) {
            // Check colliding with any object on the game board.
            int collidingZone = getCollidingZone();
            if (collidingZone != -1) {
                // Get colliding object.
                GObject collidingObject = getCollidingObject(collidingZone);
                // If ball collision with wall and its position is bottom than board game, current turn is fail.
                if ((collidingObject.getColor() == WALLS_COLOR) && (ball.getY() >= getHeight())) {
                    playSound("glassbreak.wav");
                    pause(1000);
                    break;
                }
                // Change ball direction after collision with any object on the game board.
                changeDirectionAfterCollision(collidingZone);
                // If ball collision with brick delete it.
                if ((collidingObject.getColor() != PADDLE_COLOR) && (collidingObject.getColor() != WALLS_COLOR)) {
                    totalBricksCount = deleteBrick(collidingObject, totalBricksCount);
                    if (totalBricksCount == 0)
                        break;
                } else
                    playSound("click.wav");
            }
            // Move ball to new position and pause.
            ball.move(vX, vY);
            pause(500 / 24);
        }
        return totalBricksCount;
    }

    /**
     * Delete one brick which the ball is colliding.
     *
     * @param collidingObject - Brick which the ball is colliding.
     * @param totalBricksCount - Total bricks count before current brick is deleted.
     * @return - Total bricks count after current brick was deleted.
     */
    private int deleteBrick(GObject collidingObject, int totalBricksCount) {
        playSound("bonus.wav");
        remove(collidingObject);
        totalBricksCount --;
        return totalBricksCount;
    }

    /**
     * Completely revised system of ricochets.
     * The new direction of the ball is selected depending on the colliding zone of the ball with an object.
     *
     * @param collidingZone
     */
    private void changeDirectionAfterCollision(int collidingZone) {
        switch (collidingZone) {
            case 0:
                vY = Math.abs(vY);
                break;
            case 1:
                vX = -Math.abs(vX);
                vY = Math.abs(vY);
                break;
            case 2:
                vX = -Math.abs(vX);
                break;
            case 3:
                vX = -Math.abs(vX);
                vY = -Math.abs(vY);
                break;
            case 4:
                vY = -Math.abs(vY);
                break;
            case 5:
                vX = Math.abs(vX);
                vY = -Math.abs(vY);
                break;
            case 6:
                vX = Math.abs(vX);
                break;
            case 7:
                vX = Math.abs(vX);
                vY = Math.abs(vY);
                break;
        }
    }

    /**
     * Get colliding zone of the ball with an object. In total there are 8 zones located around the ball.
     * Zones numbered from 0 to 7 from the top of the ball and following in a clockwise direction
     * with an interval of 45 degrees.
     *
     * @return - Number of the balls colliding zone.
     */
    private int getCollidingZone() {
        double ballCenterX = ball.getX() + BALL_RADIUS;
        double ballCenterY = ball.getY() + BALL_RADIUS;
        for (int collidingZone = 0; collidingZone < 8; collidingZone ++)
            if (getElementAt(ballCenterX + (BALL_RADIUS + 1) * Math.cos(collidingZone * Math.PI / 4 - Math.PI / 2),
                    ballCenterY + (BALL_RADIUS + 1) * Math.sin(collidingZone  * Math.PI / 4 - Math.PI / 2)) != null)
                return collidingZone;
        return -1;
    }

    /**
     * Get an object which the ball is colliding in the colliding zone.
     *
     * @param collidingZone - Number of the balls colliding zone.
     * @return - An object which the ball is colliding.
     */
    private GObject getCollidingObject(int collidingZone) {
        double ballCenterX = ball.getX() + BALL_RADIUS;
        double ballCenterY = ball.getY() + BALL_RADIUS;
        GObject collidingObject = getElementAt(ballCenterX + (BALL_RADIUS + 1) * Math.cos(collidingZone * Math.PI / 4 - Math.PI / 2),
                ballCenterY + (BALL_RADIUS + 1) * Math.sin(collidingZone  * Math.PI / 4 - Math.PI / 2));
        return collidingObject;
    }

}