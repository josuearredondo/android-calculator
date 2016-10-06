package com.josue.calculator;


/**
 * Created by Josué ARREDONDO on 06/10/2016.
 */

public class Calculator {
    private String number;
    private float result;
    private boolean activeOperator;

    public Calculator(String number) {
        this.number = number;
    }
    public void setCalculator (String newNumber) {
        this.number = newNumber;
    }
    public boolean getActiveOperator() {
        return activeOperator;
    }
    public void setActiveOperator(boolean activated) {
        activeOperator = activated;
    }
    public void addOperator(String operator) {
        StringBuffer numberSB = new StringBuffer(number);
        numberSB.append(operator);
        number = numberSB.toString();
        activeOperator = true;
    }
    public String resultOperation(String number) {
        float number1;
        number1 = Float.parseFloat(this.number.replaceAll("[^\\d.]", ""));
        float number2 = Float.parseFloat(number);
        if(this.number.contains("*")){
            result = number1*number2;
        } else if(this.number.contains("+")){
            result = number1+number2;
        } else if(this.number.contains("-")){
            result = number1-number2;
        } else if(this.number.contains("/")){
            result = number1/number2;
        }
        return new Float(result).toString().replaceAll("\\.?0*$", "");
    }
    public String getCalculator() {
        return this.number.toString();
    }
}
