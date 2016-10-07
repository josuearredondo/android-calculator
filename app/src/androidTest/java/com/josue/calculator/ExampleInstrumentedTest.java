package com.josue.calculator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    Calculator calculator = new Calculator();
    /** Division */
    @Test
    public void divisionOperator() throws Exception {
        // When we do the division we need keep value number to use after (result button)
        calculator = new Calculator();
        calculator.setNumber("45");
        calculator.addOperator("/");
        assertEquals("1", calculator.resultOperation("45"));
    }
    /** Multiplication */
    @Test
    public void multiplicationOperator() throws Exception {
        // When we do the multiplication we need keep value number to use after (result button)
        calculator = new Calculator();
        calculator.setNumber("45");
        calculator.addOperator("*");
        assertEquals("45", calculator.resultOperation("1"));
    }
    /** Subtraction */
    @Test
    public void subtractionOperator() throws Exception {
        // When we do the subtraction we need keep value number to use after (result button)
        calculator = new Calculator();
        calculator.setNumber("45");
        calculator.addOperator("-");
        assertEquals("40", calculator.resultOperation("5"));
    }
    /** Addition */
    @Test
    public void additionOperator() throws Exception {
        // When we do the addition we need keep value number to use after (result button)
        calculator = new Calculator();
        calculator.setNumber("45");
        calculator.addOperator("+");
        assertEquals("90", calculator.resultOperation("45"));
    }
}
