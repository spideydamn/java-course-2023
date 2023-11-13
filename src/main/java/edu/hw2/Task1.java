package edu.hw2;

public class Task1 {
    private Task1() {
    }

    public sealed interface Expr {
        double evaluate();

        public record Constant(double value) implements Expr {
            public Constant(Expr value) {
                this(value.evaluate());
            }

            @Override
            public double evaluate() {
                return value;
            }
        }

        public record Negate(double value) implements Expr {
            public Negate(Expr value) {
                this(value.evaluate());
            }

            @Override
            public double evaluate() {
                return -Math.abs(value);
            }
        }

        public record Exponent(double value, double degree) implements Expr {
            public Exponent(Expr value, Expr degree) {
                this(value.evaluate(), degree.evaluate());
            }

            public Exponent(Expr value, double degree) {
                this(value.evaluate(), degree);
            }

            public Exponent(double value, Expr degree) {
                this(value, degree.evaluate());
            }

            @Override
            public double evaluate() {
                return Math.pow(value, degree);
            }
        }

        public record Addition(double value1, double value2) implements Expr {
            public Addition(Expr value1, Expr value2) {
                this(value1.evaluate(), value2.evaluate());
            }

            public Addition(Expr value1, double value2) {
                this(value1.evaluate(), value2);
            }

            public Addition(double value1, Expr value2) {
                this(value1, value2.evaluate());
            }

            @Override
            public double evaluate() {
                return value1 + value2;
            }
        }

        public record Multiplication(double value1, double value2) implements Expr {
            public Multiplication(Expr value1, Expr value2) {
                this(value1.evaluate(), value2.evaluate());
            }

            public Multiplication(double value1, Expr value2) {
                this(value1, value2.evaluate());
            }

            public Multiplication(Expr value1, double value2) {
                this(value1.evaluate(), value2);
            }

            @Override
            public double evaluate() {
                return value1 * value2;
            }
        }
    }

}
