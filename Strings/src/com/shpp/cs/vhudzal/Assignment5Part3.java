
/**
 * Created by ВЛАДИМИР on 18.12.2015.
 */
package com.shpp.cs.vhudzal;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment5Part3 extends TextProgram{

    // File name constant.
    private static final String FILE_NAME = "dictionary.txt";

    public void run() {
        ArrayList<String> words = readWordsFromFile();
        while (true) {
            String word = readLine("Enter a three-char string: ");
            println("Options words: " + optionsWords(word, words));
        }
    }

    /**
     * Read the array list of the words from the file.
     *
     * @return - Array list of the words.
     */
    private ArrayList<String> readWordsFromFile() {
        ArrayList<String> result = new ArrayList<>();
        try {
            // Open file to read.
            BufferedReader bufReader = new BufferedReader(new FileReader(FILE_NAME));
            // Read file by one line until read null.
            while (true) {
                String readString = bufReader.readLine();
                if (readString == null)
                    break;
                result.add(readString);
            }
            // Close file.
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Find all options words matching the input condition.
     *
     * @param word - Input condition.
     * @param words - Array list of the words.
     * @return - Array list of the options words.
     */
    private ArrayList<String> optionsWords(String word, ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        // Convert input condition from string to char array form.
        char[] chars = word.toLowerCase().toCharArray();
        // For all words from read array list do check input condition.
        for (int i = 0; i < words.size(); i ++)
            if (processWord(chars, words.get(i)))
                result.add(words.get(i));
        return result;
    }

    /**
     * Process one word check input condition.
     *
     * @param chars - Input conditions in the char array form.
     * @param word - Processing word.
     * @return - True if processing word satisfies the condition, or false in other case.
     */
    private boolean processWord(char[] chars, String word) {
        int charPosition = 0, startIndex = 0;
        // For all chars from the input condition array define its positions in the processing word, starting from last
        // char position.
        for (int i = 0; i < chars.length; i ++) {
            if ((charPosition = word.indexOf(chars[i], startIndex)) == -1)
                return false;
            startIndex = charPosition + 1;
        }
        return true;
    }

}

