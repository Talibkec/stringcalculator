package com.incubyte.hiring.helper;

public class StringCalculatorHelper {

    public boolean numberLessThan1000(String num) {
        return Integer.parseInt(num) <= 1000;
    }

    public boolean isNegative(int num) {
        return  num < 0;
    }
}
