package com.shpp.cs.vhudzal.ToneMatrix;

public class ToneMatrixLogic {
    /**
     * Given the contents of the tone matrix, returns a string of notes that should be played
     * to represent that matrix.
     *
     * @param toneMatrix The contents of the tone matrix.
     * @param col        The column number that is currently being played.
     * @param samples    The sound samples associated with each row.
     * @return A sound sample corresponding to all notes currently being played.
     */
    public static double[] matrixToMusic(boolean[][] toneMatrix, int col, double[][] samples) {
        boolean[] column = getColumn(toneMatrix, col);
        double[] result = sumColumnSamples(column, samples);
        return normalizeSample(result);
    }

    /**
     * Return the selected column from the tone matrix.
     *
     * @param toneMatrix - The content of the tone matrix.
     * @param col - The column number.
     * @return - The selected column from the tone matrix.
     */
    private static boolean[] getColumn(boolean[][] toneMatrix, int col) {
        boolean[] result = new boolean[toneMatrix.length];
        for (int row = 0; row < toneMatrix.length; row ++)
            result[row] = toneMatrix[row][col];
        return result;
    }

    /**
     * Return the array of the summed values of the selected samples.
     *
     * @param column - The selected column from the tone matrix.
     * @param samples - The sound samples associated with each row.
     * @return - The array of the summed values of the selected samples.
     */
    private static double[] sumColumnSamples(boolean[] column, double[][] samples) {
        double[] result = new double[ToneMatrixConstants.sampleSize()];
        for (int row = 0; row < column.length; row ++)
            if (column[row])
                for (int col = 0; col < ToneMatrixConstants.sampleSize(); col ++)
                    result[col] += samples[row][col];
        return result;
    }

    /**
     * Return the normalized sample about max value.
     *
     * @param sample - Not normalized sample.
     * @return - Normalized sample.
     */
    private static double[] normalizeSample(double[] sample) {
        double maxValue = 0.0;
        // Find max value of the sample values.
        for (int col = 0; col < ToneMatrixConstants.sampleSize(); col ++)
            if (Math.abs(sample[col]) > Math.abs(maxValue))
                maxValue = sample[col];
        // If absolute max value is bigger than 1, normalize sample about max value.
        if (Math.abs(maxValue) > 1)
            for (int col = 0; col < ToneMatrixConstants.sampleSize(); col++)
                sample[col] /= maxValue;
        return sample;
    }
}
