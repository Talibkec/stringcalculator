package com.incubyte.hiring.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringCalculatorParser {

    public List<String> getNumbers(String numbers, String delims){
        List<String> nums = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(numbers, delims);
        while (st.hasMoreTokens()) {
            nums.add(st.nextToken());
        }
        return nums;
    }

    public String getDeliminators(String numbers){
        String deliminators = ",";
        if(numbers.startsWith("//")){
            deliminators =  getDeliminator(numbers);
        }

        return deliminators;
    }

    public String getNumSubString(String numbers){
        if (numbers.startsWith("//")) {
            //Contains custom deliminator
            int lastNewLineIndex = numbers.lastIndexOf("\n");
            numbers = numbers.substring(lastNewLineIndex + 1);
        } else {
            //Default deliminator
            numbers = removeNewLineChars(numbers);
        }

        return numbers;
    }

    public String removeNewLineChars(String numbers) {
        return numbers.replaceAll("\\n", ",");
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
