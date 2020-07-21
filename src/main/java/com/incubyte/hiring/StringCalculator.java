package com.incubyte.hiring;

import com.incubyte.hiring.exception.NegativesNumbersException;
import com.incubyte.hiring.helper.StringCalculatorHelper;
import com.incubyte.hiring.parser.StringCalculatorParser;
import java.util.List;

public class StringCalculator {

    StringCalculatorParser scp = new StringCalculatorParser();
    StringCalculatorHelper sch = new StringCalculatorHelper();

    public int add(String numbers) throws NegativesNumbersException{

        int sum = 0;
        if (numbers == null || numbers.equalsIgnoreCase("")) {
            sum = 0;
        } else {

            String deliminators = scp.getDeliminators(numbers);
            numbers = scp.getNumSubString(numbers);
            List<String> nums = scp.getNumbers(numbers, deliminators);
            //what if “1,\n”  ---   Not mentioned in the document how it should be handled.
            String negativeNums = "";
            for (int i = 0; i < nums.size(); i++) {
                if(sch.numberLessThan1000(nums.get(i))/*Number bigger than 1000 should be ignored*/){
                    int num = Integer.parseInt(nums.get(i));
                    sum = sum + num;
                    if(sch.isNegative(num)){
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

}
