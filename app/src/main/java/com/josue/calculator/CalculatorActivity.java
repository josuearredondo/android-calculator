package com.josue.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    Calculator calculator;
    boolean activeOperator = false;
    TextView tvDigit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // Find elements
        tvDigit = (TextView) findViewById(R.id.tvDigit);

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

        Button btnSIN = (Button) findViewById(R.id.btnSIN);
        Button btnCOS = (Button) findViewById(R.id.btnCOS);
        Button btnTAN = (Button) findViewById(R.id.btnTAN);
        Button btnXp2 = (Button) findViewById(R.id.btnXp2);
        Button btnSINm1 = (Button) findViewById(R.id.btnSINm1);
        Button btnCOSm1 = (Button) findViewById(R.id.btnCOSm1);
        Button btnTANm1 = (Button) findViewById(R.id.btnTANm1);
        Button btnXp3 = (Button) findViewById(R.id.btnXp3);
        Button btnEpX = (Button) findViewById(R.id.btnEpX);
        Button btn10pX = (Button) findViewById(R.id.btn10pX);
        Button btn1DivX = (Button) findViewById(R.id.btn1DivX);
        Button btnXpY = (Button) findViewById(R.id.btnXpY);
        Button btnLN = (Button) findViewById(R.id.btnLN);
        Button btnLOG = (Button) findViewById(R.id.btnLOG);
        Button btnSQRL = (Button) findViewById(R.id.btnSQRL);
        Button btnPlusMinus = (Button) findViewById(R.id.btnPlusMinus);

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

        /*btnSIN.setTag("sin");
        btnCOS.setTag("cos");
        btnTAN.setTag("tan");
        btnXp2.setTag("x2");
        btnSINm1.setTag("sin-1");
        btnCOSm1.setTag("cos-1");
        btnTANm1.setTag("tan-1");
        btnXp3.setTag("x3");
        btnEpX.setTag("E^X");
        btn10pX.setTag("10^X");
        btn1DivX.setTag("1/X");
        btnXpY.setTag("X^Y");
        btnLN.setTag("ln");
        btnLOG.setTag("log");
        btnSQRL.setTag("sqrl");
        btnPlusMinus.setTag("+/-");*/

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
        btnEqual.setOnClickListener(myClickButtonListener);
        btnDiv.setOnClickListener(myClickButtonListener);
        btnMult.setOnClickListener(myClickButtonListener);
        btnAdd.setOnClickListener(myClickButtonListener);
        btnSub.setOnClickListener(myClickButtonListener);
        btnComma.setOnClickListener(myClickButtonListener);
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

        /*ViewGroup group1 = (ViewGroup)findViewById(R.id.linearLayout1);
        ViewGroup group2 = (ViewGroup)findViewById(R.id.linearLayout1);
        ViewGroup group3 = (ViewGroup)findViewById(R.id.linearLayout1);
        ViewGroup group4 = (ViewGroup)findViewById(R.id.linearLayout1);
        View v;
        for(int i = 0; i < group1.getChildCount(); i++) {
            v = group1.getChildAt(i);
            if(v instanceof Button) v.setOnClickListener(myClickButtonListener);
        }*/

    }


}