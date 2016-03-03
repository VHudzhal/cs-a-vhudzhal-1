package com.shpp.cs.graphics.vhudzal;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Breakout extends WindowProgram {

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

    // Colors of the bricks rows.
    private static final Color BRICKS_ROWS_COLORS[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
/* Delay for ball animation*/
    private static final double PAUSE_TIME = 15;
/* Delay for blinking message*/
    private static final double BLINK_PAUSE = 500;
/* Number of blinks*/
    private static final int BLINK_NUM = 2;
// Number of turns.
    private static final int NTURNS = 3;

    private GRect paddle = null;
    private GOval ball = null;

    private double vX = 0, vY = 0;
    private GLabel result;

    public void run() {
        int totalBricksCount = buildBricksWall();
        createPaddle();
        addMouseListeners();
        createBall();
        playGame(totalBricksCount);
    }

    /**
     * Create a paddle in the game board.
     */
    private void createPaddle() {
        paddle = new GRect((getWidth() - PADDLE_WIDTH) / 2, getHeight() - PADDLE_Y_OFFSET,
                PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setColor(Color.BLACK);
        paddle.setFillColor(Color.BLACK);
        paddle.setFilled(true);
        add(paddle);
    }

    /**
     * Create ball in the center of the game board.
     */
    private void createBall() {
        ball = new GOval(getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS,
                BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setColor(Color.DARK_GRAY);
        ball.setFillColor(Color.BLACK);
        ball.setFilled(true);
        add(ball);
    }

    /**
     * Add bricks to the game board.
     *
     * @return - Total bricks number.
     */
    private int buildBricksWall() {
        for (int i = 0; i < NBRICK_ROWS; i ++)
            for (int j = 0; j < NBRICKS_PER_ROW; j ++) {
                GRect brick = new GRect(BRICK_X_OFFSET + j * (BRICK_WIDTH + BRICK_SEP),
                        BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT);
                brick.setColor(Color.BLACK);
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

    private void blinkMessage(GLabel message) {
        for (int i = 0; i < BLINK_NUM; i++){
               add(message);
               pause(BLINK_PAUSE * 2);
               remove(message);
               pause(BLINK_PAUSE);
        }

        }
    /**
     * Output message with game result - win or lose.
     *
     * @param totalBricksCount - Total bricks count for break to win.
     *                         If param value equals 0, game is win, else game is lose.
     */
    private void gameOver(int totalBricksCount) {
        GLabel result = null;
        if (totalBricksCount == 0)
            result = new GLabel("YOU WIN! CONGRATULATIONS!");
        else
            result = new GLabel("YOU LOSE! TRY ONES MORE!");
        result.setFont(new Font("Courier New", Font.BOLD, 24));
        result.setColor(Color.RED);
        result.setLocation((getWidth() - result.getWidth()) / 2, getHeight() / 2);
        add(result);
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
            // Get current coordinates of the ball.
            double ballX = ball.getX();
            double ballY = ball.getY();
            // Ball out from board? Current turn is fail.
            if (isOutFromBoard(ballY))
                break;
            // Collision ball with left wall? Return ball to the board and reverse horizontal direction of its moving.
            if (isCollisionWithLeftWall(ballX)) {
                ball.setLocation(0, ballY);
                vX = -vX;
            }
            // Collision ball with right wall? Return ball to the board and reverse horizontal direction of its moving.
            if (isCollisionWithRightWall(ballX)) {
                ball.setLocation(getWidth() - BALL_RADIUS * 2, ballY);
                vX = -vX;
            }
            // Collision ball with top wall? Return ball to the board and reverse vertical direction of its moving.
            if (isCollisionWithTopWall(ballY)) {
                ball.setLocation(ballX, 0);
                vY = -vY;
            }
            // Collision ball with paddle or bricks.
            GObject collidingObject = getCollidingObject();
            if (collidingObject != null)
                if (collidingObject == paddle) {
                    if (ballY < getHeight() - PADDLE_Y_OFFSET - BALL_RADIUS * 2 + vY)
                        vY = -vY;
                } else {
                    totalBricksCount = deleteBrick(collidingObject, totalBricksCount);
                    if (totalBricksCount == 0)
                        break;
                }
            // Move ball to new position and pause.
            ball.move(vX, vY);
            pause(500/24);
        }
        return totalBricksCount;
    }

    /**
     * Check collision ball with left wall.
     *
     * @param ballX - Horizontal coordinate of the ball.
     * @return - True if the collision is there or false if there not collision.
     */
    private boolean isCollisionWithLeftWall(double ballX) {
        double ballXLeftWall = 0;
        if (ballX <= ballXLeftWall)
            return true;
        else
            return false;
    }

    /**
     * Check collision ball with right wall.
     *
     * @param ballX - Horizontal coordinate of the ball.
     * @return - True if the collision is there or false if there not collision.
     */
    private boolean isCollisionWithRightWall(double ballX) {
        double ballXRightWall = getWidth() - BALL_RADIUS * 2;
        if (ballX >= ballXRightWall)
            return true;
        else
            return false;
    }

    /**
     * Check collision ball with top wall.
     *
     * @param ballY - Vertical coordinate of the ball.
     * @return - True if the collision is there or false if there not collision.
     */
    private boolean isCollisionWithTopWall(double ballY) {
        double ballYTopWall = 0;
        if (ballY <= ballYTopWall)
            return true;
        else
            return false;
    }

    /**
     * Check ball is out from the game board.
     *
     * @param ballY - Vertical coordinate of the ball.
     * @return - True if ball is out from the game board or false if ball is still on the game board.
     */
    private boolean isOutFromBoard(double ballY) {
        double ballYTurnFail = getHeight();
        if (ballY >= ballYTurnFail)
            return true;
        else
            return false;
    }

    /**
     * Delete one brick which the ball is colliding.
     *
     * @param collidingObject - Brick which the ball is colliding.
     * @param totalBricksCount - Total bricks count before current brick is deleted.
     * @return - Total bricks count after current brick was deleted.
     */
    private int deleteBrick(GObject collidingObject, int totalBricksCount) {
        vY = -vY;
        remove(collidingObject);
        totalBricksCount --;
        return totalBricksCount;
    }

    /**
     * Get an object which the ball is colliding.
     *
     * @return - An object which the ball is colliding.
     */
    private GObject getCollidingObject() {
        GObject collidingObject = null;
        double ballX = ball.getX();
        double ballY = ball.getY();
        if ((collidingObject = getElementAt(ballX, ballY)) != null)
            return collidingObject;
        if ((collidingObject = getElementAt(ballX + BALL_RADIUS * 2, ballY)) != null)
            return collidingObject;
        if ((collidingObject = getElementAt(ballX + BALL_RADIUS * 2, ballY + BALL_RADIUS * 2)) != null)
            return collidingObject;
        if ((collidingObject = getElementAt(ballX, ballY + BALL_RADIUS * 2)) != null)
            return collidingObject;
        return collidingObject;
    }

}



