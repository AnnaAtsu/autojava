package org.example;


public class Triangle {
    public static void main(String[] args) {
      PerimetrTriangle(3,5,10);
      SquareTriangle(5,5,5);

    }

    public static void PerimetrTriangle (int sideA, int sideB, int sideC) {
        System.out.println("Triangle perimert is " + getAnInt(sideA, sideB, sideC));
    }

    public static int getAnInt(int sideA, int sideB, int sideC) {
        return sideA + sideB + sideC;
    }
    public static void SquareTriangle (int a, int b, int c) {
        System.out.println("Triangle square is " + getTriangleArea(a, b, c));
    }

    public static double getTriangleArea(int a, int b, int c) {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }


}
