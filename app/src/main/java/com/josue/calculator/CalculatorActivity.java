package com.josue.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    Calculator calculator;
    boolean activeOperator = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Find elements
        final TextView tvDigit = (TextView) findViewById(R.id.tvDigit);
        Button btnC = (Button) findViewById(R.id.btnC);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        Button btnMult = (Button) findViewById(R.id.btnMult);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnSub = (Button) findViewById(R.id.btnSub);
        Button btnComma = (Button) findViewById(R.id.btnComma);
        Button btnEqual = (Button) findViewById(R.id.btnEqual);
        Button btnZero = (Button) findViewById(R.id.btnZero);
        Button btnOne = (Button) findViewById(R.id.btnOne);
        Button btnTwo = (Button) findViewById(R.id.btnTwo);
        Button btnThree = (Button) findViewById(R.id.btnThree);
        Button btnFour = (Button) findViewById(R.id.btnFour);
        Button btnFive = (Button) findViewById(R.id.btnFive);
        Button btnSix = (Button) findViewById(R.id.btnSix);
        Button btnSeven = (Button) findViewById(R.id.btnSeven);
        Button btnEight = (Button) findViewById(R.id.btnEight);
        Button btnNine = (Button) findViewById(R.id.btnNine);
        btnC.setTag("c");
        btnDiv.setTag("/");
        btnMult.setTag("*");
        btnAdd.setTag("+");
        btnSub.setTag("-");
        btnComma.setTag(".");
        btnEqual.setTag("=");
        btnZero.setTag("0");
        btnOne.setTag("1");
        btnTwo.setTag("2");
        btnThree.setTag("3");
        btnFour.setTag("4");
        btnFive.setTag("5");
        btnSix.setTag("6");
        btnSeven.setTag("7");
        btnEight.setTag("8");
        btnNine.setTag("9");

        View.OnClickListener myClickButtonListener= new View.OnClickListener() {
            public void onClick(View v) {
                String tag = (String) v.getTag();

                /** If operators buttons are pushed */
                if(tag.matches("[,/*-+,]")){
                    if (calculator == null) {
                        calculator = new Calculator();
                        calculator.setNumber(tvDigit.getText().toString());
                        calculator.addOperator(tag);
                        activeOperator = true;
                    }  else {
                        tvDigit.setText(calculator.resultOperation(tvDigit.getText().toString()));
                        calculator = null;
                    }
                }
                /** If point button pushed */
                else if (tag.contains(".")) {
                    if (!tvDigit.getText().toString().contains(".")) {
                        tvDigit.append(tag);
                    } else {
                        tvDigit.append("");
                    }
                }
                /** Result */
                else if (tag.contains("=")) {
                    if (calculator != null) {
                        tvDigit.setText(calculator.resultOperation(tvDigit.getText().toString()));
                        calculator = null;
                    } else {
                        tvDigit.append("");
                    }
                }
                /** If operators buttons are not pushed */
                else {
                    /** If the C button is pushed*/
                    if (tag.equals("c")) {
                        tvDigit.setText("0");
                        calculator = null;
                    } /** If any number is pushed*/
                    else if ((Integer.parseInt(tag) >= 0) && (Integer.parseInt(tag) < 10)) {
                        /** If one operator is attending for other number*/
                        if (calculator != null && activeOperator) {
                            activeOperator = false;
                            tvDigit.setText("0");
                        }
                        /** If there is one digit*/
                        if (tvDigit.length() == 1) {
                            /** If the first number is zero we can't add zero to the string*/
                            if (Integer.parseInt(tvDigit.getText().toString()) == 0) {
                                if (Integer.parseInt(tag) == 0) {
                                    tvDigit.setText("0");
                                } else {
                                    tvDigit.setText(tag);
                                }
                            } else {
                                tvDigit.append(tag);
                            }
                        } /** If there are more of one digit we can push any number*/
                        else {
                            tvDigit.append(tag);
                        }
                    }
                }
            }
        };
        btnC.setOnClickListener(myClickButtonListener);
        btnDiv.setOnClickListener(myClickButtonListener);
        btnMult.setOnClickListener(myClickButtonListener);
        btnAdd.setOnClickListener(myClickButtonListener);
        btnSub.setOnClickListener(myClickButtonListener);
        btnComma.setOnClickListener(myClickButtonListener);
        btnEqual.setOnClickListener(myClickButtonListener);
        btnZero.setOnClickListener(myClickButtonListener);
        btnOne.setOnClickListener(myClickButtonListener);
        btnTwo.setOnClickListener(myClickButtonListener);
        btnThree.setOnClickListener(myClickButtonListener);
        btnFour.setOnClickListener(myClickButtonListener);
        btnFive.setOnClickListener(myClickButtonListener);
        btnSix.setOnClickListener(myClickButtonListener);
        btnSeven.setOnClickListener(myClickButtonListener);
        btnEight.setOnClickListener(myClickButtonListener);
        btnNine.setOnClickListener(myClickButtonListener);
    }
}