package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import calculator.model.Calculator;

public class TestCalculator {

    private Calculator calc;

    @Before
    public void init() {
        calc = new Calculator();
    }

    @Test
    public void startsAtZero() {
        assertEquals(0.0, calc.displayNumber(), 1e-9);
    }

    @Test
    public void buildsMultiDigitNumbers() {
        calc.numberPressed(4);
        calc.numberPressed(6);
        calc.numberPressed(1);
        assertEquals(461.0, calc.displayNumber(), 1e-9);
    }

    @Test
    public void basicOpsAndChaining() {
        calc.numberPressed(2); calc.numberPressed(5);
        calc.dividePressed();
        calc.numberPressed(5);
        calc.equalsPressed();
        assertEquals(5.0, calc.displayNumber(), 1e-9);

        calc.clearPressed();

        calc.numberPressed(2); calc.numberPressed(0);
        calc.addPressed();
        calc.numberPressed(1); calc.numberPressed(5);
        calc.equalsPressed();
        assertEquals(35.0, calc.displayNumber(), 1e-9);

        calc.dividePressed();
        calc.numberPressed(1); calc.numberPressed(0);
        calc.equalsPressed();
        assertEquals(3.5, calc.displayNumber(), 1e-9);

        calc.clearPressed();

        calc.numberPressed(3);
        calc.addPressed();
        calc.numberPressed(4);
        calc.equalsPressed();
        calc.multiplyPressed();
        calc.numberPressed(2);
        calc.equalsPressed();
        assertEquals(14.0, calc.displayNumber(), 1e-9);
    }

    @Test
    public void clearResets() {
        calc.numberPressed(9);
        calc.clearPressed();
        assertEquals(0.0, calc.displayNumber(), 1e-9);
    }

    @Test
    public void decimalEntry() {
        calc.numberPressed(1); calc.numberPressed(2);
        calc.decimalPressed(); calc.decimalPressed();
        calc.numberPressed(5);
        calc.decimalPressed();
        calc.numberPressed(0);
        calc.decimalPressed();
        calc.numberPressed(5);
        assertEquals(12.505, calc.displayNumber(), 1e-9);

        calc.clearPressed();

        calc.decimalPressed();
        calc.numberPressed(5);
        assertEquals(0.5, calc.displayNumber(), 1e-9);
    }

    @Test
    public void equalsRepeatsOperation() {
        calc.numberPressed(8); calc.numberPressed(0);
        calc.subtractPressed();
        calc.numberPressed(1); calc.numberPressed(0);
        calc.equalsPressed();
        calc.equalsPressed();
        calc.equalsPressed();
        calc.equalsPressed();
        assertEquals(40.0, calc.displayNumber(), 1e-9);
    }
}
