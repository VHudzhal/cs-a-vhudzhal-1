/**
 * Created by ВЛАДИМИР on 16.12.2015.
 */
package com.shpp.cs.vhudzal;

import com.shpp.cs.a.console.TextProgram;

public class Assignment5Part1 extends TextProgram {
    char[] vowels={'A','E','I','O','U','Y'};
    public void run() {
        /* Repeatedly prompt the user for a word and print out the estimated
         * number of syllables in that word.
         */
        while (true) {
            String word = readLine("Enter a single word: ");
            println("  Syllable count: " + syllablesIn(word));
        }
    }

    /**
     * Given a word, estimates the number of syllables in that word according to the
     * heuristic specified in the handout.
     *
     * @param word A string containing a single word.
     * @return An estimate of the number of syllables in that word.
     */
        private int syllablesIn(String word) {
        int res=0;

        word=word.toUpperCase();

        for(int i=0;i<word.length();i++){
            char letter=word.charAt(i);
            if(letterIsVovel(letter)){
                if(prevLetterNotVovel(word,i)){
                    if(letterIsNotLastE(letter, word, i)){
                        res++;
                    }
                }
            }
        }

        if(res==0)
            res=1;

        return res;
    }

    /**
     * Check, if letter is last 'E'?
     * @param letter - letter to check
     * @param word - word, where check
     * @param i - position of letter in word
     * @return
     */
    private boolean letterIsNotLastE(char letter, String word, int i) {
        Boolean res=true;
        if(letter=='E'){
            if(i==word.length()-1){
                res=false;
            }
        }
        return res;
    }

    /**
     * Check, if letter, previous to i-position, is vovel
     * @param word - String word where checking
     * @param i - int position of current char
     * @return true - if char at pos i-1 is vovel
     */
    private boolean prevLetterNotVovel(String word, int i) {
        Boolean res=true;
        if(i>1){
            char ch=word.charAt(i-1);
            if(letterIsVovel(ch)){
                res=false;
            }
        }
        return res;
    }

    /**
     * Check, if letter is vovel
     * @param letter - char to check
     * @return true/false
     */
    private boolean letterIsVovel(char letter) {
        Boolean res=false;
        for(int i=0;i<vowels.length;i++){
            if(letter==vowels[i]){
                res=true;
                break;
            }
        }
        return res;
    }
}
