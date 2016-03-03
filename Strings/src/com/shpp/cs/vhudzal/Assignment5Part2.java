/**
 * Created by ВЛАДИМИР on 18.12.2015.
 */
package com.shpp.cs.vhudzal;

import com.shpp.cs.a.console.TextProgram;

public class Assignment5Part2 extends TextProgram {
    public void run() {
        /** Sit in a loop, reading numbers and adding them. */
        while (true) {
            String n1 = readLine("Enter first number:  ");
            String n2 = readLine("Enter second number: ");
            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            println();
        }
    }

    /**
     * Given two string representations of nonnegative integers, adds the
     * numbers represented by those strings and returns the result.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return A String representation of n1 + n2
     */
    private String addNumericStrings(String n1, String n2) {

        // define 2 int arrays with the numbers from n1 and n2 in reverse order
        int[] num1 = convertToIntArray(n1);
        int[] num2 = convertToIntArray(n2);

        // create array of int for result
        int[] num3;

        // sum arrays
        num3 = sumArrays(num1, num2);

        // convert to string with reverse order
        String snum3 = convertArrayToString(num3);

        return snum3;
    }

    /**
     * Convert string number in int array in reverse order
     *
     * @param n1 - source string
     * @return array of int's
     */
    private int[] convertToIntArray(String n1) {
        int[] res = new int[n1.length()];
        for (int i = 0; i < n1.length(); i++) {
            res[i] = n1.charAt(n1.length() - i - 1) - '0';
        }
        return res;
    }

    /**
     * Convert int array to string in reverse order
     *
     * @param num3 - array of int's
     * @return String
     */
    private String convertArrayToString(int[] num3) {
        String res = "";
        for (int i = 0; i < num3.length; i++) {
            res = (char) (num3[i] + '0') + res;
        }
        if (res.charAt(0) == '0') {
            res = (String) res.subSequence(1, res.length());
        }
        return res;
    }

    /**
     * Sum two arrays
     *
     * @param num1 - int array №1
     * @param num2 - int array №2
     * @return result array of int's
     */
    private int[] sumArrays(int[] num1, int[] num2) {
        int maxLength = num2.length;
        if (num1.length > maxLength) {
            maxLength = num1.length;
        }

        int[] res = new int[maxLength + 1];
        for (int i = 0; i < maxLength; i++) {
            int ch1 = 0, ch2 = 0;
            if (i < num1.length) {
                ch1 = num1[i];
            }
            if (i < num2.length) {
                ch2 = num2[i];
            }
            int tmp = ch1 + ch2;
            if (tmp < 10) {
                res[i] += tmp;
            } else {
                res[i + 1] = 1;
                tmp -= 10;
                res[i] += tmp;
            }
        }
        return res;
    }


}

