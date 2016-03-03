package com.shpp.cs.vhudzal;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ВЛАДИМИР on 18.12.2015.
 */
public class Assignment5Part4 extends TextProgram {
    	    private final static String FILENAME = "foodorigins.csv";

       public void run() {
    	        println("You array is - " + extractColumn(FILENAME, 0));

        }

    	    private ArrayList<String> extractColumn(String filename, int columnIndex) {
            ArrayList<String> res = new ArrayList<>();
              try {
                try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                   while (true) {
                        String line = br.readLine();
                      if (line == null) {
                        break;
                      }
                    //use method fieldIn to make an array from line and add particular element
                       //to res array
                      ArrayList<String> myArray = new ArrayList<String>();
    	                    myArray = fieldsIn(line);
                       res.add(myArray.get(columnIndex));
                   }
    	            }
            } catch (IOException e) {
               e.printStackTrace();
    	        }
            return res;
    	    }
      	    private ArrayList<String> fieldsIn(String line) {
          ArrayList<String> myArray = new ArrayList<String>();
    	        String[] mutableArray = line.split(",");
           //check all strings in array. the must have correct format
          for (int i = 0; i < mutableArray.length; i++) {
    	            String str = mutableArray[i];
               String iCreateNewSringFromTwo = null;
              //check if string not start with - '"' and end with - ','
               if ((str.charAt(0) == '"') || (str.charAt(str.length() - 1)) == ',') {
                 iCreateNewSringFromTwo = str + ",";
                   str = mutableArray[i + 1];
                  if (str.charAt(str.length() - 1) == '"') {
                    iCreateNewSringFromTwo = iCreateNewSringFromTwo + str;
                    myArray.add(iCreateNewSringFromTwo);
    	                }
               } else if (str.charAt(str.length() - 1) == '"') {
                 } else {
                    myArray.add(str);
                }
    	        }
    	        return myArray;
    	    }
    }