package com.incubyte.hiring;

import com.sun.xml.internal.ws.util.StringUtils;

public class StringCalculator {

    String deliminator = ",";
    public int add(String numbers){

        int sum = 0;

        if(numbers == null || numbers.equalsIgnoreCase("")){
            sum = 0;
        }
        else{

            if(numbers.startsWith("//")){
                deliminator = getDeliminator(numbers);
                int lastNewLineIndex = numbers.lastIndexOf("\n");
                numbers = numbers.substring(lastNewLineIndex + 1);
            }
            else{
                numbers = numbers.replaceAll("\\n", deliminator);
            }

            String[] nums = numbers.split(deliminator);
            if(nums.length == 1){
                sum = Integer.parseInt(numbers);
            }
            //what if “1,\n”
            else {
                for (int i = 0; i < nums.length; i++) {
                    sum += Integer.parseInt(nums[i]);
                }
            }
        }
        return sum;
    }

    private String getDeliminator(String numbers) {
        String deliminator = ",";
        if(numbers.startsWith("//")){
            int index = numbers.lastIndexOf("/") + 1;
            deliminator = "" + numbers.charAt(index);
        }
        return deliminator;
    }
}
