package com.shpp.cs.vhudzal.SG;

import acm.graphics.*;

public class SteganographyLogic {
    /**
     * Given a GImage containing a hidden message, finds the hidden message
     * contained within it and returns a boolean array containing that message.
     * <p/>
     * A message has been hidden in the input image as follows.  For each pixel
     * in the image, if that pixel has a red component that is an even number,
     * the message value at that pixel is false.  If the red component is an odd
     * number, the message value at that pixel is true.
     *
     * @param source The image containing the hidden message.
     * @return The hidden message, expressed as a boolean array.
     */
    public static boolean[][] findMessage(GImage source) {
        int[][] pixels = source.getPixelArray();
        int numRows = pixels.length;
        int numCols = pixels[0].length;
        boolean[][] message = new boolean[numRows][numCols];
        for (int row = 0; row < pixels.length; row++ ){
            for (int col = 0; col < pixels[row].length; col++){
                int red = GImage.getRed(pixels[row][col]);
                message[row][col] = analizeRedToFindMessege(red);
            }
        }

        return message;
    }

    /*The method return false(pixel does not contain a message) if red even number or
        true(pixel contains a message) if red is uneven number
    * @param red number red channel.
    * */

    private static boolean analizeRedToFindMessege(int red) {
        return ( red % 2 != 0);
    }

    /**
     * Hides the given message inside the specified image.
     * <p/>
     * The image will be given to you as a GImage of some size, and the message will
     * be specified as a boolean array of pixels, where each white pixel is denoted
     * false and each black pixel is denoted true.
     * <p/>
     * The message should be hidden in the image by adjusting the red channel of all
     * the pixels in the original image.  For each pixel in the original image, you
     * should make the red channel an even number if the message color is white at
     * that position, and odd otherwise.
     * <p/>
     * You can assume that the dimensions of the message and the image are the same.
     * <p/>
     *
     * @param message The message to hide.
     * @param source  The source image.
     * @return A GImage whose pixels have the message hidden within it.
     */
    public static GImage hideMessage(boolean[][] message, GImage source) {

        int [][] pixels = source.getPixelArray();
        for (int row = 0; row < pixels.length; row++ ){
            for (int col = 0; col < pixels[row].length; col++){
                int green = GImage.getGreen(pixels[row][col]);
                int blue = GImage.getBlue(pixels[row][col]);
                int red = GImage.getRed(pixels[row][col]);
                //If the message is present, resulting in the red channel to the uneven number
                // else to the even number
                pixels[row][col] = GImage.createRGBPixel((message[row][col]) ?  changeUnEven(red) : changeEven(red),green,blue);
            }
        }
        return new GImage(pixels);
    }

    /*The method results in the red channel to the even values
    * @param red number red channel.
    * @return red channel adjusted to an even number
    * */
    private static int changeEven(int red) {
        if (red % 2 != 0) red --;
        return red;
    }

    /*The method results in the red channel to the UNeven values
    * @param red number red channel.
    * @return red channel adjusted to an UNeven number
    * */
    private static int changeUnEven(int red) {
        if (red % 2 == 0) red ++;
        return red;
    }
}
