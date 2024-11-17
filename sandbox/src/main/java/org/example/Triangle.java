package org.example;

public class Triangle {
    private double sideA = 5;
    private double sideB = 5;
    private double sideC = 5;


    public Triangle() {
    }

    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }


    public double calculateArea() {
        double s = (sideA + sideB + sideC) / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }


    public void perimetrAndarea() {
        System.out.println("Perimetr is: " + calculatePerimeter());
        System.out.println("Area is: " + calculateArea());
    }
}