package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Тестирование общих случаев")
    void testGeneralCases() {
        // when
        var two = new Task1.Expr.Constant(2);
        var four = new Task1.Expr.Constant(4);
        var negOne = new Task1.Expr.Negate(new Task1.Expr.Constant(1));
        var sumTwoFour = new Task1.Expr.Addition(two, four);
        var mult = new Task1.Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Task1.Expr.Exponent(mult, 2);
        var res = new Task1.Expr.Addition(exp, new Task1.Expr.Constant(1));

        //then
        assertEquals(2.0, two.evaluate());
        assertEquals(4.0, four.evaluate());
        assertEquals(-1.0, negOne.evaluate());
        assertEquals(6.0, sumTwoFour.evaluate());
        assertEquals(-6.0, mult.evaluate());
        assertEquals(36.0, exp.evaluate());
        assertEquals(37.0, res.evaluate());
    }

    @Test
    @DisplayName("Тестирование переопределения операций")
    void testRedefiningOperations() {
        // when
        var two = new Task1.Expr.Constant(2);

        var negFour = new Task1.Expr.Negate(4);
        var negTwoFromConst = new Task1.Expr.Negate(two);

        var FourFromNeg = new Task1.Expr.Constant(negFour);

        var expConstDouble = new Task1.Expr.Exponent(two, 4);
        var expDoubleConst = new Task1.Expr.Exponent(4, two);
        var expConstConst = new Task1.Expr.Exponent(two, two);
        var expDoubleDouble = new Task1.Expr.Exponent(4, 4);

        var addConstDouble = new Task1.Expr.Addition(two, 4);
        var addDoubleConst = new Task1.Expr.Addition(4, two);
        var addConstConst = new Task1.Expr.Addition(two, two);
        var addDoubleDouble = new Task1.Expr.Addition(4, 4);

        var multiConstDouble = new Task1.Expr.Multiplication(two, 4);
        var multiDoubleConst = new Task1.Expr.Multiplication(4, two);
        var multiConstConst = new Task1.Expr.Multiplication(two, two);
        var multiDoubleDouble = new Task1.Expr.Multiplication(4, 4);


        //then
        assertEquals(2.0, two.evaluate());
        assertEquals(-4.0, FourFromNeg.evaluate());

        assertEquals(-4.0, negFour.evaluate());
        assertEquals(-2.0, negTwoFromConst.evaluate());

        assertEquals(16.0, expConstDouble.evaluate());
        assertEquals(16.0, expDoubleConst.evaluate());
        assertEquals(4.0, expConstConst.evaluate());
        assertEquals(256.0, expDoubleDouble.evaluate());

        assertEquals(6.0, addConstDouble.evaluate());
        assertEquals(6.0, addDoubleConst.evaluate());
        assertEquals(4.0, addConstConst.evaluate());
        assertEquals(8.0, addDoubleDouble.evaluate());

        assertEquals(8.0, multiConstDouble.evaluate());
        assertEquals(8.0, multiDoubleConst.evaluate());
        assertEquals(4.0, multiConstConst.evaluate());
        assertEquals(16.0, multiDoubleDouble.evaluate());
    }

    @Test
    @DisplayName("Тестирование арифметики")
    void testArithmetic() {
        // when
        var zero = new Task1.Expr.Constant(0);
        var plusOne = new Task1.Expr.Constant(1);
        var minusOne = new Task1.Expr.Negate(plusOne);

        var expInZerosDegree = new Task1.Expr.Exponent(128, zero);
        var expInPositiveDegree = new Task1.Expr.Exponent(128, 4);
        var expInNegativeDegree = new Task1.Expr.Exponent(2, minusOne);

        var addLargerPosSmallerNeg = new Task1.Expr.Addition(128, -15);
        var addLargerNegSmallerPos = new Task1.Expr.Addition(-128, 15);
        var addPlusZero = new Task1.Expr.Addition(128, zero);

        var multiPosNeg = new Task1.Expr.Multiplication(plusOne, minusOne);
        var multiPosPos = new Task1.Expr.Multiplication(plusOne, plusOne);
        var multiNegNeg = new Task1.Expr.Multiplication(minusOne, minusOne);
        var multiNegZero = new Task1.Expr.Multiplication(minusOne, zero);
        var multiPosZero = new Task1.Expr.Multiplication(plusOne, zero);

        //then
        assertEquals(0.0, zero.evaluate());
        assertEquals(1.0, plusOne.evaluate());
        assertEquals(-1.0, minusOne.evaluate());

        assertEquals(1.0, expInZerosDegree.evaluate());
        assertEquals(268435456.0, expInPositiveDegree.evaluate());
        assertEquals(0.5, expInNegativeDegree.evaluate());

        assertEquals(-113.0, addLargerNegSmallerPos.evaluate());
        assertEquals(113.0, addLargerPosSmallerNeg.evaluate());
        assertEquals(128.0, addPlusZero.evaluate());

        assertEquals(-1.0, multiPosNeg.evaluate());
        assertEquals(1.0, multiPosPos.evaluate());
        assertEquals(1.0, multiNegNeg.evaluate());
        assertEquals(-0.0, multiNegZero.evaluate());
        assertEquals(0.0, multiPosZero.evaluate());
    }
}
