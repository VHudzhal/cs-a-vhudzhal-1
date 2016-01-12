package com.shpp.cs.vhudzal.graphicstest;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * Created by Vladymyrlem on 06.12.2015.
 */

public class MatrixBlock extends WindowProgram {
        public static final int MARGIN_LEFT = 220;
    public static final int MARGIN_TOP = 100;
    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;
    /* The horizontal and vertical spacing between the boxes. */
    private static final int BOX_SPACING = 10;
    /* The width and height of each box. */
    private static final int BOX_SIZE = 40;
    /* The width and height of matrix. */
    private static final int matrixWidth = (BOX_SIZE*NUM_COLS) + ((NUM_COLS-1)*BOX_SPACING);
    private static final int matrixHeight = (BOX_SIZE*NUM_ROWS) + ((NUM_ROWS-1)*BOX_SPACING);
    /* The width and height of application window. */

    public void run()
    {
        drawMatrix(MARGIN_LEFT, MARGIN_TOP, matrixWidth, matrixHeight);

    }
/**
 создание матрицы, имея данные по колличеству строк, столбцов, размерам матрицы и ее координатам;
 */
    private void drawMatrix(int marginLeft, int marginTop, int width, int height) {
        for(int i = 0; i < NUM_COLS; i++) {
            drawMatrixCol(i, marginLeft, marginTop, width);
        }
        for(int j = 0; j < 6; j++) {
            drawMatrixRow(j, marginLeft, marginTop, height);
        }
    }
/**
   создание строки матрицы, которая имеет 6 клеток;
 */
    private void drawMatrixRow(int row, int marginLeft, int marginTop, int height) {
        for (int j = 0; j < NUM_ROWS; j++)
            drawCell(row, j, marginLeft, marginTop, height);
    }
/**
   создания столбца матрицы, которой состоит из 5 клеток
 */
    private void drawMatrixCol(int col, int marginLeft, int marginTop, int width) {
for (int i = 0; i < 5; i++)
        drawCell(col, i, marginLeft, marginTop, width);
        }

/**
   построение фигуры клетки матрицы, имеющей фигуру прямоугольника, с заданными:
    координатами, размерами клетки и цветом  закрашивания  клетки;
 */
    private void drawCell(int row, int col, int marginLeft, int marginTop, int width) {
            GRect matrix = new GRect(row *(matrixWidth/6) + (marginLeft),
                                     col*(matrixHeight/5)+(marginTop),
                    BOX_SIZE, BOX_SIZE);
            matrix.setFillColor(Color.BLACK);
            matrix.setFilled(true);
            add(matrix);
    }
}


