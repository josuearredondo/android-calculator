package com.josue.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements ActivityCommunicator  {
    //interface through which communication is made to fragment
    private Button btnC, btnEqual;
    private static String display;
    private boolean opActive;
    private boolean resultActive;
    Calculator calculator;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // Initialize values
        calculator = new Calculator();
        calculator.setNumber("0");
        calculator.setOperator("");
        display = "0";
        opActive = false;
        resultActive = false;

        // Find UI elements and fixing tag
        tvResult = (TextView) findViewById(R.id.tvDigit);
        btnC = (Button) findViewById(R.id.btnC);
        btnC.setTag("c");
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnEqual.setTag("=");

        View.OnClickListener myClickButtonListener= new View.OnClickListener() {
            public void onClick(View v) {
                String tag = (String) v.getTag();
                if (tag.equals("=") && !calculator.getOperator().equals("") && !display.equals("0")) {
                    display = calculator.resultOperation(display);
                    calculator.setOperator("");
                } else {
                    display = display.concat(""+"");
                }
                if (tag.equals("c")) {
                    display = "0";
                }
                tvResult.setText(display);
            }
        };
        btnC.setOnClickListener(myClickButtonListener);
        btnEqual.setOnClickListener(myClickButtonListener);
    }
    @Override
    public void passDataToActivity(String tag) {
        // If operators buttons are pushed
        if(tag.matches("[,/*-+,]")){
            if (!calculator.getOperator().equals("") && !display.equals("0")) {
                display = calculator.resultOperation(display);
                calculator.setOperator("");
                resultActive = true;
            } else {
                calculator.setNumber(display);
                calculator.setOperator(tag);
                opActive = true;
            }
        }
        // If point button pushed
        else if (tag.equals(".")) {
            if (!display.contains(".")) {
                display = display.concat(""+tag);
            } else {
                display = display.concat(""+"");
            }
        }
        // If any number is pushed
        else if ((Integer.parseInt(tag) >= 0) && (Integer.parseInt(tag) < 10)) {
            if (opActive || resultActive) {
                display = "0";
                opActive = false;
                resultActive = false;
            }
            // If one operator is attending for other number
            if (display.equals("0")) {
                if (!tag.equals("0")) {
                    display = tag;
                } else {
                    display = "0";
                }
            } else {
                display = display.concat(""+tag);
            }
        }

        tvResult.setText(display);
    }
}