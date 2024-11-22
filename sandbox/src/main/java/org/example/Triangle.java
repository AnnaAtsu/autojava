package org.example;

public class Triangle {
    public double a, b, c;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Triangle can not have a negative side");
        }
        if (((a + b) < c) || ((b + c) < a) || ((a + c)< b)) {
            throw new IllegalArgumentException("Triangle is wrong!");

        }
    }


    public double getPerimetr() {
        return a + b + c;
    }
    public double getArea() {
        double p = getPerimetr()/2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}