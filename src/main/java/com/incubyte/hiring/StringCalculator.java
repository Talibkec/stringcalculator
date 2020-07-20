package com.incubyte.hiring;

import com.incubyte.hiring.exception.NegativesNumbersException;

public class StringCalculator {

    String deliminator = ",";

    public int add(String numbers) throws NegativesNumbersException{

        int sum = 0;

        if (numbers == null || numbers.equalsIgnoreCase("")) {
            sum = 0;
        } else {

            if (numbers.startsWith("//")) {
                //Contains custom deliminator
                deliminator = getDeliminator(numbers);
                int lastNewLineIndex = numbers.lastIndexOf("\n");
                numbers = numbers.substring(lastNewLineIndex + 1);
            } else {
                //Default deliminator
                numbers = removeNewLineChars(numbers);
            }

            String[] nums = numbers.split(deliminator);

            //what if “1,\n”

            String negativeNums = "";
            for (int i = 0; i < nums.length; i++) {
                if(numberLessThan1000(nums[i])/*Number bigger than 1000 should be ignored*/){
                    int num = Integer.parseInt(nums[i]);
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
        return numbers.replaceAll("\\n", deliminator);
    }

    private String getDeliminator(String numbers) {
        String deliminator = ",";
        if (numbers.startsWith("//")) {
            int index = numbers.lastIndexOf("/") + 1;
            deliminator = "" + numbers.charAt(index);
        }
        return deliminator;
    }
}
