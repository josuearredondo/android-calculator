package com.josue.calculator;



import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class CalculatorInstrumentedTest {
    Calculator calculator = new Calculator();
    /** Division */
    @Test
    public void divisionOperator() throws Exception {
        // When we do the division we need keep value number to use after (result button)
        calculator = new Calculator();
        calculator.setNumber("45");
        calculator.addOperator("/");
        calculator.addOperator("-");
        assertEquals("0", calculator.resultOperation("45"));
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
