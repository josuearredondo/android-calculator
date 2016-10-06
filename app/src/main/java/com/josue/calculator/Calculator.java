package com.josue.calculator;

/**
 * Created by Human Booster on 06/10/2016.
 */

public class Calculator {
    static StringBuffer number;
    private double result;

    public Calculator(StringBuffer number) {
        this.number = number;
    }
    public void addOperator(String operator) {
        number.append(operator);
    }
    public String resultOperation(String number) {

        return number;
    }
    public String getCalculator() {
        return this.number.toString();
    }
}
