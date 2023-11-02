package edu.hw2;

public class Task2 {
    private Task2() {}

    public static class Rectangle {
        private final int width;
        private final int height;

        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        Rectangle setWidth(int width) {
            return new Rectangle(width, this.height);
        }

        Rectangle setHeight(int height) {
            return new Rectangle(this.width, height);
        }

        double area() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        Square(int width) {
            super(width, width);
        }
    }

}
