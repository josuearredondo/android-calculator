package com.josue.calculator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

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

    /** Point */
    @Test
    public void addPointToNoOnlyOneTime() throws Exception {
        // Adding number we can add only one point to the real number
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("45.", calculator.addPoint("45."));
    }
    /** Division */
    @Test
    public void keepNoAndDivisionOperator() throws Exception {
        // When we do the division we need keep value number to use after (result button)
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("45+", calculator.addOperator("45/"));
    }
    /** Multiplication */
    @Test
    public void keepNoAndMultiplicationOperator() throws Exception {
        // When we do the multiplication we need keep value number to use after (result button)
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("45+", calculator.addOperator("45*"));
    }
    /** Subtraction */
    @Test
    public void keepNoAndSubtractionOperator() throws Exception {
        // When we do the subtraction we need keep value number to use after (result button)
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("45+", calculator.addOperator("45-"));
    }
    /** Addition */
    @Test
    public void keepNoAndAdditionOperator() throws Exception {
        // When we do the addition we need keep value number to use after (result button)
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("45+", calculator.addOperator("45+"));
    }
    /** Result */
    @Test
    public void receiveNoAndDoOperation() throws Exception {
        // We receive the value number kept of operator before
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("90", calculator.addOperator("45+45"));
    }
}
