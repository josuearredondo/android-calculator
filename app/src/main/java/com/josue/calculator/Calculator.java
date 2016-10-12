package com.josue.calculator;


/**
 * Created by Josué ARREDONDO on 06/10/2016.
 */

public class Calculator {
    private String number;
    private String operator;
    private float result;

    public Calculator() {}

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOperator(String operator) { this.operator = operator; }

    public String getOperator() {return operator;}

    public String resultOperation(String number) {
        float number1;
        number1 = Float.parseFloat(this.number);
        float number2 = Float.parseFloat(number);
        if(this.operator.equals("*")){
            result = number1*number2;
        } else if(this.operator.equals("+")){
            result = number1+number2;
        } else if(this.operator.equals("-")){
            result = number1-number2;
        } else if(this.operator.equals("/")){
            result = number1/number2;
        }
        return new Float(result).toString().replaceAll("\\.?0*$", "");
    }
}
