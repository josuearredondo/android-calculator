package com.josue.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // find the elements
        TextView etNum1 = (TextView) findViewById(R.id.etDigit);

        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        Button btnMult = (Button) findViewById(R.id.btnMult);
        Button btnAdd = (Button) findViewById(R.id.btnSub);
        Button btnSub = (Button) findViewById(R.id.btnAdd);
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

    }
}
