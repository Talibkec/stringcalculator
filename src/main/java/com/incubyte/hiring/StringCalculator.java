package com.incubyte.hiring;

import com.incubyte.hiring.exception.NegativesNumbersException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringCalculator {

    String deliminators = ",";

    public int add(String numbers) throws NegativesNumbersException{

        int sum = 0;

        if (numbers == null || numbers.equalsIgnoreCase("")) {
            sum = 0;
        } else {

            if (numbers.startsWith("//")) {
                //Contains custom deliminator
                deliminators = getDeliminator(numbers);
                int lastNewLineIndex = numbers.lastIndexOf("\n");
                numbers = numbers.substring(lastNewLineIndex + 1);
            } else {
                //Default deliminator
                numbers = removeNewLineChars(numbers);
            }

            StringTokenizer st = new StringTokenizer(numbers, deliminators);
            List<String> nums = new ArrayList<String>();
            while (st.hasMoreTokens()) {
                nums.add(st.nextToken());
            }
            //what if “1,\n”  ---   Not mentioned in the document how it should be handled.

            String negativeNums = "";
            for (int i = 0; i < nums.size(); i++) {
                if(numberLessThan1000(nums.get(i))/*Number bigger than 1000 should be ignored*/){
                    int num = Integer.parseInt(nums.get(i));
                    sum = sum + num;
                    if(num < 0){
                        negativeNums = negativeNums.concat(num + " ");
                    }
                }
            }

            if(negativeNums.length() > 0){
                throw new NegativesNumbersException("negatives not allowed:".concat(negativeNums));
            }

        }
        return sum;
    }

    private boolean numberLessThan1000(String num) {
        return Integer.parseInt(num) <= 1000;
    }

    private String removeNewLineChars(String numbers) {
        return numbers.replaceAll("\\n", deliminators);
    }

    private String getDeliminator(String numbers) {
        //Assuming numbers are not allowed as deliminators.
        String deliminators = ",";
        if (numbers.startsWith("//")) {
            String delimPart = numbers.substring(0, numbers.lastIndexOf("\n"))
                    .replace("//","")
                    .replace("[","").replace("]", "1");
            deliminators = "";
            for(String delim : delimPart.split("1")){
                deliminators+=delim;
            }

        }
        return deliminators;
    }
}
